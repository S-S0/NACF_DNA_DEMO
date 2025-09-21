package com.example.demo.service;

import com.example.demo.domain.FinancialRatios;
import com.example.demo.domain.ServFinancialRatios;
import com.example.demo.domain.dto.*;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.FinancialRatiosRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {

    private final RestClient client;
    private final String model;
    private final Integer maxOutputTokens;
    private final Double temperature;
    private final boolean enableWebSearchByDefault;
    private final DemoRepository demoRepository;

    public OpenAiService(
            RestClient openAiRestClient,
            @Value("${openai.model}") String model,
            @Value("${openai.max-output-tokens:800}") Integer maxOutputTokens,
            @Value("${openai.temperature:0.2}") Double temperature,
            @Value("${openai.enable-web-search:true}") boolean enableWebSearchByDefault, FinancialRatiosRepository repo, DemoRepository demoRepository // 필요시 yml에서 on/off
    ) {
        this.client = openAiRestClient;
        this.model = model;
        this.maxOutputTokens = maxOutputTokens;
        this.temperature = temperature;
        this.enableWebSearchByDefault = enableWebSearchByDefault;
        this.demoRepository = demoRepository;
    }

    /**
     * 사용자 프롬프트를 받고 Responses API 호출
     * - pg_2 컨텍스트는 프런트에서 머지되어 전달됨
     * - 웹검색 툴(web_search_preview)을 활성화하여, 없는 데이터도 실제로 찾아서 인용 가능
     */
    public String ask(String userPrompt) {
        // 시스템 규칙: 누락/비교/추정/웹검색 사용 지시
        String instructions = """
                당신은 한국어로 답하는 금융/경영 분석 어시스턴트입니다.
                - [pg_2_context]가 제공되면 참고하되, 값이 없거나 일부 항목이 비어도 거절하지 말고 반드시 답하세요.
                - 실제 수치가 필요하지만 컨텍스트에 없으면 웹검색 툴을 호출해 최신 정보를 찾아 인용(출처 명시)하세요.
                - 확정치가 아닐 경우 '추정' 또는 '범위'로 표기하고 근거를 1~2줄로 요약하세요.
                - 비교 질문은 한쪽 데이터가 없어도 업계 일반범위/공시/리포트 관례를 근거로 비교를 완성하세요.
                - 답변 포맷: 1)요약 2)핵심해설(불릿) 3)간단 예시/표(선택)
                """;

        List<Map<String, Object>> rows = demoRepository.getFinancialRatios("707015");

        // 요청 content.type 은 반드시 "input_text"
        ContentBlock userBlock = new ContentBlock("input_text", rows.toString());
        InputMessage userMessage = new InputMessage("user", List.of(userBlock));

        // === tools 구성 ===
        List<Map<String, Object>> tools = null;
        Boolean parallelToolCalls = null;

        if (enableWebSearchByDefault) {
            // 웹검색 미리보기 툴 (Responses API 내장)
            Map<String, Object> webTool = Map.of(
                    "type", "web_search_preview",
                    "search_context_size", "medium"   // small|medium|large (선택)
            );
            tools = List.of(webTool);
            parallelToolCalls = Boolean.TRUE;        // 여러 툴을 함께 쓸 때 유용 (지금은 1개여도 OK)
        }

        ResponsesCreateRequest req = new ResponsesCreateRequest(
                model,
                List.of(userMessage),
                instructions,
                maxOutputTokens,
                temperature,
                tools,                  // ← 웹검색 툴 전달
                parallelToolCalls       // ← 병렬툴 호출 허용
        );

        ResponsesCreateResponse res = client.post()
                .uri("/responses")
                .body(req)
                .retrieve()
                .body(ResponsesCreateResponse.class);

        if (res == null || res.output() == null || res.output().isEmpty()) {
            return "(응답이 비어 있습니다)";
        }

        StringBuilder sb = new StringBuilder();
        for (ResponseOutput out : res.output()) {
            if (out.content() == null) continue;
            for (OutputContent c : out.content()) {
                if ("output_text".equalsIgnoreCase(c.type())) {
                    sb.append(c.text());
                }
            }
        }
        String text = sb.toString();
        return text.isBlank() ? "(텍스트 응답 없음)" : text.trim();
    }
}
