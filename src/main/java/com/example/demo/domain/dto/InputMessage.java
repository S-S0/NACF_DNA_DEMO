package com.example.demo.domain.dto;

import java.util.List;

public record InputMessage(
        String role,
        List<ContentBlock> content
) {}
