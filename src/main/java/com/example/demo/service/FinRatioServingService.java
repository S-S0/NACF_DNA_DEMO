package com.example.demo.service;

import com.example.demo.repository.FinRatioServingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FinRatioServingService {

    private final FinRatioServingRepository repo;
    private final ObjectMapper om = new ObjectMapper();

    public List<Map<String, Object>> getRows(String brc, Integer years) {
        List<Map<String, Object>> all = repo.findByBrc(brc);
        int n = (years == null || years <= 0) ? all.size() : Math.min(years, all.size());
        return all.subList(0, n); // basyy DESC이므로 앞에서 n개 = 최신 n개년
    }

    public String toJson(List<Map<String, Object>> rows) {
        try { return om.writeValueAsString(rows); }
        catch (JsonProcessingException e) { return "[]"; }
    }

    public String toContext(String brc, Integer years) {
        List<Map<String, Object>> rows = getRows(brc, years);
        String json = toJson(rows);
        return """
               [fin_ratio_serving]
               - brc: %s
               - years: %s
               - format: json_rows(latest_first)
               - note: Korean column aliases preserved

               %s
               """.formatted(brc, (years == null ? "all" : years), json);
    }
}
