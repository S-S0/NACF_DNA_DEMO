package com.example.demo.controller;

import com.example.demo.service.FinRatioServingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finratio/serving")
public class FinRatioServingController {

    private final FinRatioServingService service;

    @GetMapping(value = "/context", produces = MediaType.TEXT_PLAIN_VALUE)
    public String context(@RequestParam String brc,
                          @RequestParam(required = false) Integer years) {
        // 기본 5개년 권장
        Integer y = (years == null ? 5 : years);
        return service.toContext(brc, y);
    }
}
