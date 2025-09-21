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
    // 사무소 지표
    public static final String VALUE_BY_BRC =
            "SELECT pbr, per, ev_sales, ev_ebitda, ev_ebit \n" +
                    "  FROM brc_value\n" +
                    " WHERE BRC = :brc\n" +
                    " ORDER BY BASYY";
    // 전달용 - 재무비율
    public static final String SERVING_FIN_RATIO = "SELECT brc AS '사무소코드'," +
            "basyy AS '기준년도'," +
            "net_interest_margin_pct AS '순이자마진(%)'," +
            "pre_tax_profit_margin_pct AS '세전순이익률(%)'," +
            "net_profit_margin_pct AS '순이익률(%)'," +
            "efficiency_ratio_pct AS '효율성비율(%)'," +
            "return_on_equity_roe_pct AS '자기자본이익률(%) - ROE'," +
            "return_on_assets_roa_pct AS '총자산순이익률(%) - ROA'," +
            "cet1_ratio_pct AS '보통주자본(CET1)비율(%)'," +
            "tier1_ratio_pct AS '기본자본(Tier1)비율(%)'," +
            "total_capital_ratio_pct AS '총자본비율(%)'," +
            "tier1_leverage_ratio_pct AS 'Tier1 레버리지비율(%)'," +
            "loan_to_deposit_ratio_pct AS '예대율(%)'," +
            "liquidity_coverage_ratio_pct AS '유동성커버리지비율(%)'," +
            "total_asset_turnover_pct AS '총자산회전율(%)'," +
            "financial_asset_turnover_pct AS '금융자산회전율(%)'," +
            "operating_leverage_ratio_pct AS '영업레버리지비율(%)'," +
            "npl_ratio_pct AS '총여신대비부실채권 비율(%)'," +
            "loan_loss_reserve_ratio_pct AS '총여신대비대손충당금 비율(%)'," +
            "deposit_interest_rate_pct AS '예수부채이자율(%)'," +
            "interest_fee_to_loan_ratio_pct AS '총여신대비이자및수수료(%)'," +
            "piotroski_f_score AS '피오트로스키 F-스코어'," +
            "beneish_m_score AS '베네시 M-스코어'," +
            "g_score AS '모한람 G-스코어'," +
            "operating_cf_conversion_ratio_pct AS '영업현금흐름전환비율(%)'," +
            "asset_efficiency_ratio_pct AS '자산효율성비율(%)'," +
            "dividend_yield_pct AS '배당수익률(%)'," +
            "total_return_pct AS '총 수익률(%)'," +
            "dividend_payout_ratio_pct AS '배당성향(%)'," +
            "adjusted_payout_ratio_pct  AS '수정배당성향(%)'" +
            "FROM financial_ratios" +
            "WHERE BRC = :brc";
}
