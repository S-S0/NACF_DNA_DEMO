package com.example.demo.domain.dto;

import java.util.List;

public record ResponsesCreateResponse(
        List<ResponseOutput> output
) {}
