package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "sample")
@Access(AccessType.FIELD)
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
