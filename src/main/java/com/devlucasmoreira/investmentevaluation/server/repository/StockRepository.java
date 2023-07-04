package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
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

    @Query("SELECT s FROM Stock s WHERE s.amount > 0 ORDER BY s.active ASC")
    List<Stock> findStocksActiveOrder();

    @Query("SELECT s FROM Stock s WHERE UPPER(s.active) LIKE %:active%")
    Optional<Stock> findByActive(@Param("active") String active);

    @Query("SELECT SUM(s.amount) FROM Stock s WHERE s.stockType IN (:stockTypeList) AND s.show = true")
    Integer getTotalAmountByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

    @Query("SELECT SUM(s.purchaseValue) FROM Stock s WHERE s.stockType IN (:stockTypeList) AND s.show = true")
    BigDecimal getTotalPurchaseValueByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

    @Query("SELECT SUM(s.currentValue) FROM Stock s WHERE s.stockType IN (:stockTypeList) AND s.show = true")
    BigDecimal getTotalCurrentValueByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

    @Query("SELECT SUM(s.amount) FROM Stock s WHERE s.show = true")
    Integer getTotalAmount();

    @Query("SELECT SUM(s.currentValue) FROM Stock s WHERE s.show = true")
    BigDecimal getTotalCurrentValue();

    @Query("SELECT SUM(s.purchaseValue) FROM Stock s WHERE s.show = true")
    BigDecimal getTotalPurchaseValue();

    @Query("SELECT s FROM Stock s WHERE s.show = true AND s.stockType IN (:stockTypeList) ORDER BY s.active ASC")
    List<Stock> listActivesByType(@Param("stockTypeList") List<StockTypeEnum> stockTypeList);

}
