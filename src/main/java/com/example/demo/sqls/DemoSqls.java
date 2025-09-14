package com.example.demo.sqls;

public class DemoSqls {
    public static final String FIND_BY_ENO = "SELECT * FROM sample WHERE eno = :eno";

    // 팩터 분석
    public static final String FACTOR_BY_BRC =
            "SELECT volatility, value_factor, size_factor, momentum, beta, outlook\n" +
            "FROM factor_score\n" +
            "WHERE BRC = :brc\n" +
            "  AND BASYY = '2024';  ";
    // 주가
    public static final String PRICE_BY_BRC =
            "SELECT bas_dt, open, high, low, close \n" +
                    "  FROM stock_price\n" +
                    " WHERE BRC = :brc ";
    // 전망치
    public static final String OUTLOOK_BY_BRC =
            "SELECT high,close,low\n" +
                    "  FROM stock_outlook\n" +
                    "WHERE BRC = :brc\n" +
                    "  AND BAS_DT = '9999-12-31'";

    // 손익현황  (메인하단_첫번째)
    public static final String INCOME_BY_BRC =
            "SELECT interest_income1/1000000 AS interest_income1 \n" +
                    ",fee_income1/1000000 AS fee_income1 \n" +
                    ",other_operating_income1/1000000 AS other_operating_income1\n" +
                    ",economic_operating_income1/1000000 AS economic_operating_income1\n" +
                    ",education_support_income1/1000000 AS education_support_income1\n" +
                    ",non_operating_income1/1000000 AS non_operating_income1\n" +
                    ",net_profit_margin1\n" +
                    "  FROM office_financials\n" +
                    " WHERE BRC = :brc\n" +
                    "   AND BASYY BETWEEN '2022' AND '2024'\n" +
                    " ORDER BY BASYY";

    // 배당현황  (메인하단_두번째)
    public static final String PROFIT_BY_BRC =
            "SELECT common_dividend/1000000 AS common_dividend\n" +
                    ",common_dividend_ratio2\n" +
                    "  FROM office_financials\n" +
                    " WHERE BRC = :brc\n" +
                    "   AND BASYY BETWEEN '2022' AND '2024'\n" +
                    " ORDER BY BASYY";

    // 이익성장률  (메인하단_세번째)
    public static final String PROGROWTH_BY_BRC =
            "SELECT net_income_growth_ratio3\n" +
                    ",operating_revenue_growth_ratio3\n" +
                    ",non_operating_income_growth_ratio3\n" +
                    "  FROM office_financials\n" +
                    " WHERE BRC = :brc\n" +
                    "   AND BASYY BETWEEN '2022' AND '2024'\n" +
                    " ORDER BY BASYY";

    // 사무소 설명
    public static final String DESC_BY_BRC =
            "SELECT brc, brnm, ceo_nm, foundation_dt, employees, address, description " +
                    "FROM brc_info " +
                    "WHERE BRC = :brc";
}
