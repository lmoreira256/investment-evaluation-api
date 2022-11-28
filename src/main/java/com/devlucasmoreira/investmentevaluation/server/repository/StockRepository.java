package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {

    boolean existsByActive(String active);

    @Query("SELECT s FROM Stock s WHERE UPPER(s.active) LIKE %:active%")
    Page<Stock> findByActive(@Param("active") String active, Pageable pageable);

    @Query("SELECT s FROM Stock s WHERE UPPER(s.active) LIKE %:active%")
    Optional<Stock> findByActive(@Param("active") String active);

}
