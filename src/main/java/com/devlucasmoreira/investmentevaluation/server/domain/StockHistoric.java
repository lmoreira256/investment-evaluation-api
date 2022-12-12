package com.devlucasmoreira.investmentevaluation.server.domain;

import com.devlucasmoreira.investmentevaluation.server.enums.StockHistoricTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "stock_historic")
public class StockHistoric {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "actual_value")
    private BigDecimal actualValue;

    @Column(name = "purchase_value")
    private BigDecimal purchaseValue;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "cash_return")
    private BigDecimal cashReturn;

    @Column(name = "profitability")
    private BigDecimal profitability;

    @Enumerated(EnumType.STRING)
    @Column(name = "historic_type")
    private StockHistoricTypeEnum historicType;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
