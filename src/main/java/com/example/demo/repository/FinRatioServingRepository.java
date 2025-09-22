package com.example.demo.repository;

import com.example.demo.sqls.DemoSqls;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class FinRatioServingRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public List<Map<String, Object>> findByBrc(String brc) {
        Map<String, Object> params = Map.of("brc", brc);
        // DemoSqls.SERVING_FIN_RATIO 사용
        // (필요하면 ORDER BY basyy DESC 추가해도 OK)
        return jdbc.queryForList(DemoSqls.SERVING_FIN_RATIO + " ORDER BY basyy DESC", params);
    }
}
