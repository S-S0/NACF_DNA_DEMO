package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "financial_ratios")
@IdClass(FinancialRatiosId.class)  // 복합키: brc + basyy
public class FinancialRatios implements Serializable {

    @Id
    @Column(name = "brc", length = 6, nullable = false)
    private String brc;

    @Id
    @Column(name = "basyy", length = 4, nullable = false)
    private String basyy;

    @Column(name = "net_interest_margin_pct")
    private BigDecimal netInterestMarginPct;

    @Column(name = "pre_tax_profit_margin_pct")
    private BigDecimal preTaxProfitMarginPct;

    @Column(name = "net_profit_margin_pct")
    private BigDecimal netProfitMarginPct;

    @Column(name = "efficiency_ratio_pct")
    private BigDecimal efficiencyRatioPct;

    @Column(name = "return_on_equity_roe_pct")
    private BigDecimal returnOnEquityRoePct;

    @Column(name = "incremental_roe_1y_pct")
    private BigDecimal incrementalRoe1yPct;

    @Column(name = "incremental_roe_3y_pct")
    private BigDecimal incrementalRoe3yPct;

    @Column(name = "incremental_roe_5y_pct")
    private BigDecimal incrementalRoe5yPct;

    @Column(name = "return_on_assets_roa_pct")
    private BigDecimal returnOnAssetsRoaPct;

    @Column(name = "cet1_ratio_pct")
    private BigDecimal cet1RatioPct;

    @Column(name = "tier1_ratio_pct")
    private BigDecimal tier1RatioPct;

    @Column(name = "total_capital_ratio_pct")
    private BigDecimal totalCapitalRatioPct;

    @Column(name = "tier1_leverage_ratio_pct")
    private BigDecimal tier1LeverageRatioPct;

    @Column(name = "loan_to_deposit_ratio_pct")
    private BigDecimal loanToDepositRatioPct;

    @Column(name = "liquidity_coverage_ratio_pct")
    private BigDecimal liquidityCoverageRatioPct;

    @Column(name = "total_asset_turnover_pct")
    private BigDecimal totalAssetTurnoverPct;

    @Column(name = "financial_asset_turnover_pct")
    private BigDecimal financialAssetTurnoverPct;

    @Column(name = "operating_leverage_ratio_pct")
    private BigDecimal operatingLeverageRatioPct;

    @Column(name = "npl_ratio_pct")
    private BigDecimal nplRatioPct;

    @Column(name = "loan_loss_reserve_ratio_pct")
    private BigDecimal loanLossReserveRatioPct;

    @Column(name = "deposit_interest_rate_pct")
    private BigDecimal depositInterestRatePct;

    @Column(name = "interest_fee_to_loan_ratio_pct")
    private BigDecimal interestFeeToLoanRatioPct;

    @Column(name = "piotroski_f_score")
    private BigDecimal piotroskiFScore;

    @Column(name = "beneish_m_score")
    private BigDecimal beneishMScore;

    @Column(name = "g_score")
    private BigDecimal gScore;

    @Column(name = "operating_cf_conversion_ratio_pct")
    private BigDecimal operatingCfConversionRatioPct;

    @Column(name = "asset_efficiency_ratio_pct")
    private BigDecimal assetEfficiencyRatioPct;

    @Column(name = "dividend_yield_pct")
    private BigDecimal dividendYieldPct;

    @Column(name = "total_return_pct")
    private BigDecimal totalReturnPct;

    @Column(name = "dividend_payout_ratio_pct")
    private BigDecimal dividendPayoutRatioPct;

    @Column(name = "adjusted_payout_ratio_pct")
    private BigDecimal adjustedPayoutRatioPct;
}
