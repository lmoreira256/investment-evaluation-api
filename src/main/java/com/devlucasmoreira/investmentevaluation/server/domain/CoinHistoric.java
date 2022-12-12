package com.devlucasmoreira.investmentevaluation.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coin_historic")
public class CoinHistoric {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "actual_value")
    private BigDecimal actualValue;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "cash_return")
    private BigDecimal cashReturn;

    @Column(name = "profitability")
    private BigDecimal profitability;

}
