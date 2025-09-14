package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "factor_score")
public class FactorScore {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String brc;

    @Column(name = "brnm", length = 50, nullable = false,
            columnDefinition = "VARCHAR(50) COMMENT '사무소명'")
    private String brnm;

    @Column(name = "basyy", length = 4, nullable = false,
            columnDefinition = "CHAR(4) COMMENT '기준년도'")
    private String basyy;

    @Column(name = "volatility", nullable = false,
            columnDefinition = "TINYINT COMMENT '변동성 점수 (0~100)'")
    private Integer volatility;

    @Column(name = "value_factor", nullable = false,
            columnDefinition = "TINYINT COMMENT '밸류 점수 (0~100)'")
    private Integer valueFactor;

    @Column(name = "size_factor", nullable = false,
            columnDefinition = "TINYINT COMMENT '사이즈 점수 (0~100)'")
    private Integer sizeFactor;

    @Column(name = "momentum", nullable = false,
            columnDefinition = "TINYINT COMMENT '모멘텀 점수 (0~100)'")
    private Integer momentum;

    @Column(name = "beta", nullable = false,
            columnDefinition = "TINYINT COMMENT '베타 점수 (0~100)'")
    private Integer beta;

    @Column(name = "outlook", nullable = false,
            columnDefinition = "TINYINT COMMENT '전망치 점수 (0~100)'")
    private Integer outlook;

    public FactorScore() {
    }
}
