package com.example.demo.domain.dto;

import java.util.List;

public record ResponseOutput(
        List<OutputContent> content
) {}
