package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.domain.view.EarningSummaryView;
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

    @Query("SELECT SUM(e.amountPaid) FROM Earning e")
    BigDecimal getTotalValue();

    @Query("SELECT e.stock.active as item, SUM(e.amountPaid) as totalValue FROM Earning e GROUP BY e.stock.active ORDER BY totalValue DESC")
    List<EarningSummaryView> getEarningSummaryForActive();

    @Query(value = "SELECT TO_CHAR(DATE_TRUNC('month', e.payday), 'MM/YYYY') AS item, SUM(e.amount_paid) as totalValue " +
            "FROM Earning e " +
            "GROUP BY DATE_TRUNC('month', e.payday) " +
            "ORDER BY DATE_TRUNC('month', e.payday) DESC " +
            "LIMIT 24", nativeQuery = true)
    List<EarningSummaryView> getEarningSummaryForMonth();

}
