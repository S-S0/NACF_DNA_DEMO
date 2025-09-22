package com.example.demo.domain.dto;

import java.util.List;

public record ResponsesCreateResponse(
        List<ResponseOutput> output,
        String output_text   // 루트 편의필드 (최종 텍스트)
) {}
