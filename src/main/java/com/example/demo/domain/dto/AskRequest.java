package com.example.demo.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record AskRequest(@NotBlank String prompt) {}
