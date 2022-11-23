package com.devlucasmoreira.investmentevaluation.server.domain;

import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "active")
    private String active;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Column(name = "cash_return")
    private BigDecimal cashReturn;

    @Column(name = "profitability")
    private BigDecimal profitability;

    @Column(name = "purchase_value")
    private BigDecimal purchaseValue;

    @Column(name = "average_purchase")
    private BigDecimal averagePurchase;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_type")
    private StockTypeEnum stockType;

    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}
