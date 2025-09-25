package com.example.demo.service;

import com.example.demo.domain.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {

    private final RestClient client;
    private final String model;
    private final Integer maxOutputTokens;
    // 현재 모델에서 미지원 → 요청에는 포함하지 않지만, yml 호환을 위해 필드만 보관
    private final Double temperature;
    private final boolean enableWebSearchByDefault;

    public OpenAiService(
            RestClient openAiRestClient,
            @Value("${openai.model}") String model,
            @Value("${openai.max-output-tokens:2000}") Integer maxOutputTokens,
            @Value("${openai.temperature:0.0}") Double temperature,
            @Value("${openai.enable-web-search:true}") boolean enableWebSearchByDefault
    ) {
        this.client = openAiRestClient;
        this.model = model;
        this.maxOutputTokens = maxOutputTokens;
        this.temperature = temperature;
        this.enableWebSearchByDefault = enableWebSearchByDefault;
    }

    /** 비교·특정 은행명이 들어오면 웹검색을 강제 ON */
    private boolean needsWebSearch(String prompt) {
        if (prompt == null) return false;
        String p = prompt.toLowerCase();
        // 비교 키워드
        if (p.contains("비교") || p.contains("/비교")) return true;
        // 국내 주요 은행/기관 키워드
        String[] banks = {"신한", "국민", "kb", "하나", "우리", "카카오", "농협", "nh", "ibk", "기업은행"};
        for (String b : banks) if (p.contains(b)) return true;
        // 최신성 요구(오늘, 최근 분기 등) → 외부 조회 필요 가능성 높음
        String[] fresh = {"최신", "오늘", "최근", "분기", "잠정", "속보", "업데이트"};
        for (String f : fresh) if (p.contains(f)) return true;
        return false;
    }

    /**
     * 사용자 프롬프트를 받고 Responses API 호출
     * - pg_2 컨텍스트는 프런트에서 머지되어 전달됨
     * - 비교/은행명/최신성 키워드가 감지되면 web_search_preview를 강제 ON
     */
    public String ask(String userPrompt) {
        // 시스템 규칙
        String instructions = """
                당신은 한국어로 답하는 금융/경영 분석 어시스턴트입니다.
                - 먼저 제공된 [fin_ratio_serving] 참고 하되, 값이 없거나 일부 항목이 비어도 거절하지 말고 반드시 답하세요.
                - 실제 수치가 필요하지만 컨텍스트에 없으면 웹검색 툴을 호출해 최신 정보를 찾아 인용(출처 명시)하세요.
                - 확정치가 아닐 경우 '추정' 또는 '범위'로 표기하고 근거를 1~2줄로 요약하세요.
                - 비교 질문은 한쪽 데이터가 없어도 업계 일반범위/공시/리포트 관례를 근거로 비교를 완성하세요.
                - 국내 및 글로벌 경제상황에 맞춰 선택한 전략 옵션을 달성하기 위한 구체적인 경영전략을 같이 제시하세요.
                - 답변은 1500자 이내로 간결하게 해주세요.
                - 사용자가 특정 기관 및 금융 기관(예: 카카오뱅크, 신한은행, KB국민은행, 하나은행 등)을 비교 대상으로 요청했으나 제공된 [fin_ratio_serving]에 그 기관 데이터가 없을 경우:
                  → 반드시 web_search_preview 도구를 사용해 해당 기관의 최신 재무비율(ROE, ROA, NIM, CET1, LCR 등)을 검색해 요약하고 비교 결과를 작성하세요.
                - 도구 호출 여부와 무관하게, 항상 마지막에는 한국어 '요약'을 출력하세요.
                - 사무소코드 100158은 동서울농협, 707015는 안동농협, 801819는 진주원예농협으로 말해줘
                """;

        // 메시지
        ContentBlock userBlock = new ContentBlock("input_text", userPrompt);
        InputMessage userMessage = new InputMessage("user", List.of(userBlock));

        // === tools 구성 ===
        List<Map<String, Object>> tools = null;
        Boolean parallelToolCalls = null;

        // 기본 사용 또는 강제 사용
        boolean forceWeb = needsWebSearch(userPrompt);
        if ((enableWebSearchByDefault || forceWeb)) {
            Map<String, Object> webTool = Map.of(
                    "type", "web_search_preview",
                    "search_context_size", "medium"
            );
            tools = List.of(webTool);
            parallelToolCalls = Boolean.TRUE;
        }

        // 생성자 선택
        ResponsesCreateRequest req = (tools != null && parallelToolCalls != null)
                ? new ResponsesCreateRequest(
                model,
                List.of(userMessage),
                instructions,
                maxOutputTokens,
                tools,
                parallelToolCalls
        )
                : new ResponsesCreateRequest(
                model,
                List.of(userMessage),
                instructions,
                maxOutputTokens
        );

        ResponsesCreateResponse res = client.post()
                .uri("/responses")
                .body(req)
                .retrieve()
                .body(ResponsesCreateResponse.class);

        // ── 출력 파싱 보강: 1) output_text 편의필드 → 2) content[].output_text → 3) 안전 Fallback ──
        if (res == null) return "(응답이 비어 있습니다)";

        // 1) 편의 필드 우선
        String finalText = null;
        try {
            // DTO에 output_text가 존재해야 함 (아래 DTO 보강 참고)
            finalText = res.output_text();
        } catch (Exception ignore) {}

        // 2) content[] fallback
        if (finalText == null || finalText.isBlank()) {
            StringBuilder sb = new StringBuilder();
            if (res.output() != null) {
                for (ResponseOutput out : res.output()) {
                    if (out.content() == null) continue;
                    for (OutputContent c : out.content()) {
                        if ("output_text".equalsIgnoreCase(c.type())) {
                            sb.append(c.text());
                        }
                    }
                }
            }
            finalText = sb.toString();
        }

        // 3) 최종 가드
        if (finalText == null || finalText.isBlank()) {
            return "요청을 처리하는 중 도구 호출만 수행되어 최종 문장이 누락되었습니다. " +
                    "같은 요청을 다시 시도하거나, 조금 더 구체적으로 적어 주세요. 예:\n" +
                    "- \"/비교 현재 사무소 vs 신한은행: 2022~2024 ROE/ROA/NIM 표 + 한줄 해설\"";
        }

        return finalText.trim();
    }
}
