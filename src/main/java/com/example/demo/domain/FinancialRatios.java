package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "financial_ratios")
public class FinancialRatios {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String brc;

    @Column(name = "basyy", length = 4, nullable = false,
            columnDefinition = "CHAR(4) COMMENT '기준년도'")
    private String basyy;

    @Column(name = "net_interest_margin_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '순이자마진(%)'")
    private BigDecimal netInterestMarginPct;

    @Column(name = "pre_tax_profit_margin_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '세전순이익률(%)'")
    private BigDecimal preTaxProfitMarginPct;

    @Column(name = "net_profit_margin_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '순이익률(%)'")
    private BigDecimal netProfitMarginPct;

    @Column(name = "efficiency_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '효율성비율(%)'")
    private BigDecimal efficiencyRatioPct;

    @Column(name = "return_on_equity_roe_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '자기자본이익률(%) - ROE'")
    private BigDecimal returnOnEquityRoePct;

    @Column(name = "incremental_roe_1y_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '증분 자기자본이익률(%) - 1Y'")
    private BigDecimal incrementalRoe1yPct;

    @Column(name = "incremental_roe_3y_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '증분 자기자본이익률(%) - 3Y'")
    private BigDecimal incrementalRoe3yPct;

    @Column(name = "incremental_roe_5y_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '증분 자기자본이익률(%) - 5Y'")
    private BigDecimal incrementalRoe5yPct;

    @Column(name = "return_on_assets_roa_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총자산순이익률(%) - ROA'")
    private BigDecimal returnOnAssetsRoaPct;

    @Column(name = "cet1_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '보통주자본(CET1)비율(%)'")
    private BigDecimal cet1RatioPct;

    @Column(name = "tier1_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '기본자본(Tier1)비율(%)'")
    private BigDecimal tier1RatioPct;

    @Column(name = "total_capital_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총자본비율(%)'")
    private BigDecimal totalCapitalRatioPct;

    @Column(name = "tier1_leverage_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT 'Tier1 레버리지비율(%)'")
    private BigDecimal tier1LeverageRatioPct;

    @Column(name = "loan_to_deposit_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '예대율(%)'")
    private BigDecimal loanToDepositRatioPct;

    @Column(name = "liquidity_coverage_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '유동성커버리지비율(%)'")
    private BigDecimal liquidityCoverageRatioPct;

    @Column(name = "total_asset_turnover_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총자산회전율(%)'")
    private BigDecimal totalAssetTurnoverPct;

    @Column(name = "financial_asset_turnover_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '금융자산회전율(%)'")
    private BigDecimal financialAssetTurnoverPct;

    @Column(name = "operating_leverage_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '영업레버리지비율(%)'")
    private BigDecimal operatingLeverageRatioPct;

    @Column(name = "npl_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총여신대비부실채권 비율(%)'")
    private BigDecimal nplRatioPct;

    @Column(name = "loan_loss_reserve_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총여신대비대손충당금 비율(%)'")
    private BigDecimal loanLossReserveRatioPct;

    @Column(name = "deposit_interest_rate_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '예수부채이자율(%)'")
    private BigDecimal depositInterestRatePct;

    @Column(name = "interest_fee_to_loan_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총여신대비이자및수수료(%)'")
    private BigDecimal interestFeeToLoanRatioPct;

    @Column(name = "piotroski_f_score", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '피오트로스키 F-스코어'")
    private BigDecimal piotroskiFScore;

    @Column(name = "beneish_m_score", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '베네시 M-스코어'")
    private BigDecimal beneishMScore;

    @Column(name = "g_score", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT 'G-스코어'")
    private BigDecimal gScore;

    @Column(name = "operating_cf_conversion_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '영업현금흐름전환비율(%)'")
    private BigDecimal operatingCfConversionRatioPct;

    @Column(name = "asset_efficiency_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '자산효율성비율(%)'")
    private BigDecimal assetEfficiencyRatioPct;

    @Column(name = "dividend_yield_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '배당수익률(%)'")
    private BigDecimal dividendYieldPct;

    @Column(name = "total_return_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '총 수익률(%)'")
    private BigDecimal totalReturnPct;

    @Column(name = "dividend_payout_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '배당성향(%)'")
    private BigDecimal dividendPayoutRatioPct;

    @Column(name = "adjusted_payout_ratio_pct", precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) COMMENT '수정배당성향(%)'")
    private BigDecimal adjustedPayoutRatioPct;

    public FinancialRatios() {}
}
