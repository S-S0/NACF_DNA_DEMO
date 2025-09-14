package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "office_financials")
public class OfficeFinancials {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String brc;

    @Column(name = "basyy", length = 4, nullable = false,
            columnDefinition = "CHAR(4) COMMENT '기준년도'")
    private String basyy;

    @Column(name = "total_assets", nullable = false,
            columnDefinition = "BIGINT COMMENT '자산총계'")
    private Long totalAssets;

    @Column(name = "total_assets_prev", nullable = false,
            columnDefinition = "BIGINT COMMENT '자산총계(전기)'")
    private Long totalAssetsPrev;

    @Column(name = "deposit_total", nullable = false,
            columnDefinition = "BIGINT COMMENT '예수금'")
    private Long depositTotal;

    @Column(name = "financial_loan_bond", nullable = false,
            columnDefinition = "BIGINT COMMENT '금융업대출채권'")
    private Long financialLoanBond;

    @Column(name = "loss_prov_cooperative", nullable = false,
            columnDefinition = "BIGINT COMMENT '대손충당금(상호금융자금대출금)'")
    private Long lossProvCooperative;

    @Column(name = "loss_prov_policy", nullable = false,
            columnDefinition = "BIGINT COMMENT '대손충당금(정책자금대출금)'")
    private Long lossProvPolicy;

    @Column(name = "loss_prov_insurance_loan", nullable = false,
            columnDefinition = "BIGINT COMMENT '보험대출대손충당금'")
    private Long lossProvInsuranceLoan;

    @Column(name = "interest_income", nullable = false,
            columnDefinition = "BIGINT COMMENT '이자수익'")
    private Long interestIncome;

    @Column(name = "interest_expense", nullable = false,
            columnDefinition = "BIGINT COMMENT '이자비용'")
    private Long interestExpense;

    @Column(name = "pre_tax_credit_income", nullable = false,
            columnDefinition = "BIGINT COMMENT '신용사업회계법인세비용차감전계속사업손익'")
    private Long preTaxCreditIncome;

    @Column(name = "operating_revenue", nullable = false,
            columnDefinition = "BIGINT COMMENT '영업수익'")
    private Long operatingRevenue;

    @Column(name = "operating_revenue_prev", nullable = false,
            columnDefinition = "BIGINT COMMENT '영업수익(전기)'")
    private Long operatingRevenuePrev;

    @Column(name = "operating_income", nullable = false,
            columnDefinition = "BIGINT COMMENT '영업이익'")
    private Long operatingIncome;

    @Column(name = "operating_income_prev", nullable = false,
            columnDefinition = "BIGINT COMMENT '영업이익(전기)'")
    private Long operatingIncomePrev;

    @Column(name = "non_operating_expense", nullable = false,
            columnDefinition = "BIGINT COMMENT '영업외비용'")
    private Long nonOperatingExpense;

    @Column(name = "deposit_interest", nullable = false,
            columnDefinition = "BIGINT COMMENT '예수금이자'")
    private Long depositInterest;

    @Column(name = "commission_income", nullable = false,
            columnDefinition = "BIGINT COMMENT '수수료수익'")
    private Long commissionIncome;

    @Column(name = "credit_business_income", nullable = false,
            columnDefinition = "BIGINT COMMENT '신용사업회계계속사업이익'")
    private Long creditBusinessIncome;

    @Column(name = "depreciation", nullable = false,
            columnDefinition = "BIGINT COMMENT '감가상각비'")
    private Long depreciation;

    @Column(name = "net_income", nullable = false,
            columnDefinition = "BIGINT COMMENT '당기순이익'")
    private Long netIncome;

    @Column(name = "profitability_subtotal", nullable = false,
            columnDefinition = "BIGINT COMMENT '수익성 소계'")
    private Long profitabilitySubtotal;

    @Column(name = "bad_loans", nullable = false,
            columnDefinition = "BIGINT COMMENT '부실여신'")
    private Long badLoans;

    @Column(name = "total_loans", nullable = false,
            columnDefinition = "BIGINT COMMENT '총여신'")
    private Long totalLoans;

    @Column(name = "common_dividend", nullable = false,
            columnDefinition = "BIGINT COMMENT '보통출자배당액'")
    private Long commonDividend;

    @Column(name = "preferred_dividend", nullable = false,
            columnDefinition = "BIGINT COMMENT '우선출자배당액'")
    private Long preferredDividend;

    @Column(name = "user_dividend", nullable = false,
            columnDefinition = "BIGINT COMMENT '이용고배당액'")
    private Long userDividend;

    @Column(name = "provision_reserve", nullable = false,
            columnDefinition = "BIGINT COMMENT '충당금적립액'")
    private Long provisionReserve;

    @Column(name = "net_income_per_share", nullable = false,
            columnDefinition = "BIGINT COMMENT '1좌당 당기순이익'")
    private Long netIncomePerShare;

    @Column(name = "capital_contribution", nullable = false,
            columnDefinition = "BIGINT COMMENT '출자금'")
    private Long capitalContribution;

    @Column(name = "total_sum", nullable = false,
            columnDefinition = "BIGINT COMMENT '합계'")
    private Long totalSum;

    @Column(name = "loan_deposit_ratio", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '예대율(%)'")
    private BigDecimal loanDepositRatio;

    @Column(name = "liquidity_coverage_ratio", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '유동성커버리지비율'")
    private BigDecimal liquidityCoverageRatio;

    @Column(name = "president_name", length = 30, nullable = false,
            columnDefinition = "VARCHAR(30) COMMENT '조합장'")
    private String presidentName;

    @Column(name = "executive_name", length = 30, nullable = false,
            columnDefinition = "VARCHAR(30) COMMENT '상임이사'")
    private String executiveName;

    @Column(name = "common_dividend_ratio2", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '보통출자배당률(%)'")
    private BigDecimal commonDividendRatio2;

    @Column(name = "net_income_growth_ratio3", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '당기순이익성장률(%)'")
    private BigDecimal netIncomeGrowthRatio3;

    @Column(name = "operating_revenue_growth_ratio3", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '영업수익성장률(%)'")
    private BigDecimal operatingRevenueGrowthRatio3;

    @Column(name = "non_operating_income_growth_ratio3", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '영업외수익성장률(%)'")
    private BigDecimal nonOperatingIncomeGrowthRatio3;

    @Column(name = "interest_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '이자수익'")
    private Long interestIncome1;

    @Column(name = "fee_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '수수료수익'")
    private Long feeIncome1;

    @Column(name = "other_operating_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '기타영업수익'")
    private Long otherOperatingIncome1;

    @Column(name = "economic_operating_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '경제사업영업수익'")
    private Long economicOperatingIncome1;

    @Column(name = "education_support_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '교육지원사업수익'")
    private Long educationSupportIncome1;

    @Column(name = "non_operating_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '영업외수익'")
    private Long nonOperatingIncome1;

    @Column(name = "net_profit_margin1", precision = 5, scale = 2, nullable = false,
            columnDefinition = "DECIMAL(5,2) COMMENT '매출액대비당기순이익률(%)'")
    private BigDecimal netProfitMargin1;

    @Column(name = "revenue1", nullable = false,
            columnDefinition = "BIGINT COMMENT '매출액1'")
    private Long revenue1;

    @Column(name = "net_income1", nullable = false,
            columnDefinition = "BIGINT COMMENT '당기순이익1'")
    private Long netIncome1;

    public OfficeFinancials() {}
}
