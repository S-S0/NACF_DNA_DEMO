package com.example.demo.domain.dto;

import java.util.List;
import java.util.Map;

/**
 * OpenAI Responses API 요청 DTO
 * - tools / parallel_tool_calls 필드 추가로 웹검색 등 내장툴 사용 가능
 * - 참고: input[]에는 InputMessage(role, content[input_text]) 사용
 */
public record ResponsesCreateRequest(
        String model,
        List<InputMessage> input,
        String instructions,
        Integer max_output_tokens,
        Double temperature,

        // ★ 추가된 필드들
        List<Map<String, Object>> tools,
        Boolean parallel_tool_calls
) {
    // 기존 생성자와의 호환을 위해 보조 생성자 유지
    public ResponsesCreateRequest(
            String model,
            List<InputMessage> input,
            String instructions,
            Integer max_output_tokens,
            Double temperature
    ) {
        this(model, input, instructions, max_output_tokens, temperature, null, null);
    }
}
