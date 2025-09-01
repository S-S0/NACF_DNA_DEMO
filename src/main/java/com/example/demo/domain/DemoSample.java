package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sample")
@Getter
@Setter
public class DemoSample {
    @Id
    private String eno;

    @Column(nullable = false)
    private String empnm;

    @Column(nullable = false)
    private String brc;

    @Column(nullable = false)
    private String brnm;
}
