package com.example.demo.domain;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FinancialRatiosId implements Serializable {
    private String brc;
    private String basyy; // CHAR(4)
}
