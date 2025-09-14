package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.sqls.DemoSqls;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.example.demo.sqls.DemoSqls.FIND_BY_ENO;

@Repository
public class DemoRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public DemoRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Spring JDBC 사용 테스트용
    public DemoSample findByEno(String eno) {
        Map<String, ?> params = Collections.singletonMap("eno", eno);

        return jdbc.queryForObject(FIND_BY_ENO, params, new BeanPropertyRowMapper<>(DemoSample.class));
    }
    public List<FactorScore> factorByBrc(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<FactorScore> factorScores;
        factorScores = jdbc.query(
                DemoSqls.FACTOR_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(FactorScore.class)
        );

        return factorScores;
    }

    public List<StockPrice> priceByBrc(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<StockPrice> stockPrices;
        stockPrices = jdbc.query(
                DemoSqls.PRICE_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(StockPrice.class)
        );

        return stockPrices;
    }

    public List<StockOutlook> outlookByBrc(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<StockOutlook> stockOutlooks;
        stockOutlooks = jdbc.query(
                DemoSqls.OUTLOOK_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(StockOutlook.class)
        );

        return stockOutlooks;
    }

    public List<OfficeFinancials> incomeByBrc(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<OfficeFinancials> incomePrices;
        incomePrices = jdbc.query(
                DemoSqls.INCOME_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(OfficeFinancials.class)
        );

        return incomePrices;
    }

    public List<OfficeFinancials> profitByBrc(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<OfficeFinancials> profitMargins;
        profitMargins = jdbc.query(
                DemoSqls.PROFIT_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(OfficeFinancials.class)
        );

        return profitMargins;
    }

    public List<OfficeFinancials> progrowthByBRC(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<OfficeFinancials> profitGrowths;
        profitGrowths = jdbc.query(
                DemoSqls.PROGROWTH_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(OfficeFinancials.class)
        );

        return profitGrowths;
    }

    public List<BrcInfo> descByBRC(String brc) {
        // 파라미터 맵 설정
        Map<String, Object> params = Collections.singletonMap("brc", brc);

        // 쿼리 실행 및 결과 매핑
        List<BrcInfo> descBrcs;
        descBrcs = jdbc.query(
                DemoSqls.DESC_BY_BRC,
                params,
                new BeanPropertyRowMapper<>(BrcInfo.class)
        );

        return descBrcs;
    }
}
