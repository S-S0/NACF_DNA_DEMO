package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "stock_price_demo")
@Access(AccessType.FIELD)
public class StockPrice {

    @Id
    @Column(nullable = false, length = 6)
    private String brc;

    private Date bas_dt;

    private Integer open;

    private Integer high;

    private Integer low;

    private Integer close;
}
