package com.example.demo.repository;

import com.example.demo.domain.DemoSample;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;

import static com.example.demo.sqls.DemoSqls.FIND_BY_ENO;

@Repository
public class DemoRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public DemoRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public DemoSample findByEno(String eno) {
        Map<String, ?> params = Collections.singletonMap("eno", eno);

        return jdbc.queryForObject(FIND_BY_ENO, params, new BeanPropertyRowMapper<>(DemoSample.class));
    }

}
