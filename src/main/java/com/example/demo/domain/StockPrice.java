package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "stock_price")
public class StockPrice {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String officeCode;   // 지점 코드

    @Column(name = "bas_dt", nullable = false,
            columnDefinition = "DATE COMMENT '기준일자'")
    private LocalDate basDt;     // 기준일

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '시가'")
    private int open;           // 시가

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '고가'")
    private int high;           // 고가

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '저가'")
    private int low;           // 저가

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '종가'")
    private int close;           // 종가

    public StockPrice() {}
}
