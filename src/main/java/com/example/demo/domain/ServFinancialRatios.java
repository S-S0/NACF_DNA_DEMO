package com.example.demo.domain;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ServFinancialRatios {

    private String brc;
    private String basyy;

    private BigDecimal netInterestMarginPct;
    private BigDecimal preTaxProfitMarginPct;
    private BigDecimal netProfitMarginPct;
    private BigDecimal efficiencyRatioPct;
    private BigDecimal returnOnEquityRoePct;
    private BigDecimal returnOnAssetsRoaPct;
    private BigDecimal cet1RatioPct;
    private BigDecimal tier1RatioPct;
    private BigDecimal totalCapitalRatioPct;
    private BigDecimal tier1LeverageRatioPct;
    private BigDecimal loanToDepositRatioPct;
    private BigDecimal liquidityCoverageRatioPct;
    private BigDecimal totalAssetTurnoverPct;
    private BigDecimal financialAssetTurnoverPct;
    private BigDecimal operatingLeverageRatioPct;
    private BigDecimal nplRatioPct;
    private BigDecimal loanLossReserveRatioPct;
    private BigDecimal depositInterestRatePct;
    private BigDecimal interestFeeToLoanRatioPct;
    private BigDecimal piotroskiFScore;
    private BigDecimal beneishMScore;
    private BigDecimal gScore;
    private BigDecimal operatingCfConversionRatioPct;
    private BigDecimal assetEfficiencyRatioPct;
    private BigDecimal dividendYieldPct;
    private BigDecimal totalReturnPct;
    private BigDecimal dividendPayoutRatioPct;
    private BigDecimal adjustedPayoutRatioPct;
}
