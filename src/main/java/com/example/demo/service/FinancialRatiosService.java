package com.example.demo.service;

import com.example.demo.domain.FinancialRatios;
import com.example.demo.repository.FinancialRatiosRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FinancialRatiosService {

    private final FinancialRatiosRepository repo;

    public FinancialRatiosService(FinancialRatiosRepository repo) {
        this.repo = repo;
    }
    /**
     * 특정 brc, 여러 년도의 데이터 조회 후 Map으로 반환
     */
    public Map<String, FinancialRatios> getRatiosForYears(String brc, List<String> years) {
        // JPA 메서드 호출
        List<FinancialRatios> rows = repo.findByBrcAndBasyyInOrderByBasyyAsc(brc, years);

        // Map<basyy, FinancialRatios> 형태로 변환
        Map<String, FinancialRatios> result = new HashMap<>();
        for (FinancialRatios r : rows) {
            result.put(r.getBasyy(), r);
        }
        return result;
    }
}
