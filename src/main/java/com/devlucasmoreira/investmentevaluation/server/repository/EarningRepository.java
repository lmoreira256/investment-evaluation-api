package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface EarningRepository extends JpaRepository<Earning, UUID> {

    @Query("SELECT e FROM Earning e WHERE UPPER(e.stock.active) LIKE %:active%")
    Page<Earning> findByActive(@Param("active") String active, Pageable pageable);

    List<Earning> findAllByOrderByCreatedAtDesc();

    @Query("SELECT SUM(e.currentValue) FROM Earning e")
    BigDecimal getTotalValue();

}