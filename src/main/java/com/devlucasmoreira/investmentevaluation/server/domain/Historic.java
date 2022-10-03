package com.devlucasmoreira.investmentevaluation.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historic")
public class Historic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "date")
    private OffsetDateTime date;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "cash_return")
    private BigDecimal cashReturn;

    @Column(name = "profitability")
    private BigDecimal profitability;

}
