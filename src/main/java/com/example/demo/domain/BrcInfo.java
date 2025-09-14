package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "brc_info")
public class BrcInfo {

    @Id
    @Column(name = "brc", length = 6, nullable = false,
            columnDefinition = "VARCHAR(6) COMMENT '사무소코드'")
    private String brc;

    @Column(name = "brnm", length = 50, nullable = false,
            columnDefinition = "VARCHAR(100) COMMENT '사무소명'")
    private String brnm;

    @Column(name = "ceo_nm", length = 50, nullable = false,
            columnDefinition = "VARCHAR(50) COMMENT '조합장'")
    private String ceoNm;

    @Column(name = "foundation_dt", length = 50, nullable = false,
            columnDefinition = "VARCHAR(50) COMMENT '설립일'")
    private String foundationDt;

    @Column(name = "employees", nullable = false,
            columnDefinition = "INT COMMENT '직원수'")
    private Integer employees;

    @Column(name = "address", length = 100, nullable = false,
            columnDefinition = "VARCHAR(100) COMMENT '주소'")
    private String address;

    @Column(name = "description", length = 1000, nullable = false,
            columnDefinition = "TEXT COMMENT '설명'")
    private String description;

    public BrcInfo() {
    }
}
