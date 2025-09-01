package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "brc_info")
@Access(AccessType.FIELD)
public class BrcInfo {

    @Id
    @Column(nullable = false, length = 6)
    private String brc; // 사무소코드

    @Column(length = 100)
    private String brnm;    // 사무소명

    @Column(length = 50)
    private String union_ceo_nm;   // 조합장명

    private Integer employees;  // 직원수

    @Column(columnDefinition = "Text")
    private String description; // 소개

}
