package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "factor_score")
@Access(AccessType.FIELD)
public class FactorScore {
    @Id
    @Column(nullable = false, length = 6)
    private String brc;

    private Integer f_vol;

    private Integer f_value;

    private Integer f_size;

    private Integer f_mmt;

    private Integer f_beta;

    private Integer f_outlook;
}
