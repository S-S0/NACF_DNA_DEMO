package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "brc_value")
public class BrcValue {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String brc;

    @Id
    @Column(name = "basyy", length = 4, nullable = false,
            columnDefinition = "CHAR(4) COMMENT '기준년도'")
    private String basyy;

    @Column(name = "pbr", precision = 15, scale = 4,
            columnDefinition = "DECIMAL(15,4) COMMENT 'pbr'")
    private BigDecimal pbr;

    @Column(name = "per", precision = 15, scale = 4,
            columnDefinition = "DECIMAL(15,4) COMMENT 'per'")
    private BigDecimal per;

    @Column(name = "ev_sales", precision = 15, scale = 4,
            columnDefinition = "DECIMAL(15,4) COMMENT 'ev_sales'")
    private BigDecimal evSales;

    @Column(name = "ev_ebitda", precision = 15, scale = 4,
            columnDefinition = "DECIMAL(15,4) COMMENT 'ev_ebitda'")
    private BigDecimal evEbitda;

    @Column(name = "ev_ebit", precision = 15, scale = 4,
            columnDefinition = "DECIMAL(15,4) COMMENT 'ev_ebit'")
    private BigDecimal evEbit;

    public BrcValue() {
    }
}
