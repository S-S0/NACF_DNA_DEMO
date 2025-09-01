package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "stock_outlook")
public class StockOutlook {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String officeCode;   // VARCHAR(6) NOT NULL

    @Column(name = "bas_dt", nullable = false,
            columnDefinition = "DATE COMMENT '기준일자'")
    private LocalDate basDt;     // DATE NOT NULL

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '시가'")
    private int open;           // INT NOT NULL

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '고가'")
    private int high;           // INT NOT NULL

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '저가'")
    private int low;           // INT NOT NULL

    @Column(nullable = false,
            columnDefinition = "INT COMMENT '종가'")
    private int close;           // INT NOT NULL

    public StockOutlook() {}

    // getter/setter ...
}
