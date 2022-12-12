package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {

    boolean existsByActive(String active);

    @Query("SELECT s FROM Stock s WHERE UPPER(s.active) LIKE %:active%")
    Page<Stock> findByActive(@Param("active") String active, Pageable pageable);

    @Query("SELECT s FROM Stock s WHERE UPPER(s.active) LIKE %:active%")
    Optional<Stock> findByActive(@Param("active") String active);

    @Query("SELECT SUM(s.amount) FROM Stock s WHERE s.stockType IN (:stockTypeList)")
    Integer getTotalAmountByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

    @Query("SELECT SUM(s.purchaseValue) FROM Stock s WHERE s.stockType IN (:stockTypeList)")
    BigDecimal getTotalPurchaseValueByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

    @Query("SELECT SUM(s.currentValue) FROM Stock s WHERE s.stockType IN (:stockTypeList)")
    BigDecimal getTotalActualValueByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

}
