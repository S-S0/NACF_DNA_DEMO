package com.example.demo.controller;

import com.example.demo.domain.dto.AskRequest;
import com.example.demo.domain.dto.AskResponse;
import com.example.demo.service.OpenAiService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final OpenAiService openAiService;

    public AiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping(value = "/ask",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AskResponse ask(@RequestBody @Valid AskRequest req) {
        String answer = openAiService.ask(req.prompt());
        return new AskResponse(answer);
    }
}
