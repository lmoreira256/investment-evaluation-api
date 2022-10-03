package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface CoinRepository extends JpaRepository<Coin, UUID> {

    @Query("SELECT SUM(c.currentValue) FROM Coin c")
    BigDecimal getTotalCurrentValue();

    @Query("SELECT SUM(c.amount) FROM Coin c")
    BigDecimal getTotalAmount();


}
