package com.devlucasmoreira.investmentevaluation.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "checkpoint")
public class Checkpoint {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Column(name = "purchase_value")
    private BigDecimal purchaseValue;

    @Column(name = "result_value")
    private BigDecimal resultValue;

    @Column(name = "result_percentage_value")
    private BigDecimal resultPercentageValue;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
