// src/main/java/com/example/demo/domain/dto/ResponsesCreateRequest.java
package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponsesCreateRequest(
        String model,
        List<InputMessage> input,
        String instructions,
        Integer max_output_tokens,
        List<Map<String, Object>> tools,
        Boolean parallel_tool_calls
) {
    public ResponsesCreateRequest(
            String model,
            List<InputMessage> input,
            String instructions,
            Integer max_output_tokens
    ) {
        this(model, input, instructions, max_output_tokens, null, null);
    }
}
