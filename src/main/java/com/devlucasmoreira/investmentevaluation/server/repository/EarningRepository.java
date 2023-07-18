package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.domain.view.EarningSummaryView;
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

    List<Earning> findTop30ByOrderByCreatedAtDesc();

    @Query("SELECT e FROM Earning e WHERE UPPER(e.active.name) LIKE %:active%")
    List<Earning> findByActive(@Param("active") String active);

    @Query("SELECT SUM(e.amountPaid) FROM Earning e")
    BigDecimal getTotalValue();

    @Query("SELECT e.active.name as item, SUM(e.amountPaid) as totalValue FROM Earning e GROUP BY e.active.name ORDER BY totalValue DESC")
    List<EarningSummaryView> getEarningSummaryForActive(Pageable pageable);

    @Query("SELECT e.active.name as item, SUM(e.amountPaid) as totalValue " +
            "FROM Earning e " +
            "WHERE e.active.name = :active " +
            "GROUP BY e.active.name " +
            "ORDER BY totalValue ASC ")
    List<EarningSummaryView> getEarningSummaryByActive(@Param("active") String active);

    @Query(value = "SELECT TO_CHAR(DATE_TRUNC('month', e.payday), 'MM/YYYY') AS item, SUM(e.amount_paid) as totalValue " +
            "FROM Earning e " +
            "GROUP BY DATE_TRUNC('month', e.payday) " +
            "ORDER BY DATE_TRUNC('month', e.payday) ASC " +
            "LIMIT 24", nativeQuery = true)
    List<EarningSummaryView> getEarningSummaryForMonth();

    @Query(value = "SELECT TO_CHAR(DATE_TRUNC('month', e.payday), 'MM/YYYY') AS item, SUM(e.amount_paid) as totalValue " +
            "FROM Earning e " +
            "WHERE TO_CHAR(DATE_TRUNC('month', e.payday), 'MM/YYYY') = :month " +
            "GROUP BY DATE_TRUNC('month', e.payday) " +
            "ORDER BY DATE_TRUNC('month', e.payday) ASC " +
            "LIMIT 24", nativeQuery = true)
    List<EarningSummaryView> getEarningSummaryByMonth(@Param("month") String month);

    @Query(value = "SELECT SUM(e.amount_paid) " +
            "FROM earning e " +
            "WHERE DATE_TRUNC('month', e.payday) = DATE_TRUNC('month', now()) " +
            "AND DATE_TRUNC('year', e.payday) = DATE_TRUNC('year', now())", nativeQuery = true)
    BigDecimal getTotalLastMonth();

    @Query(value = "SELECT SUM(e.amount_paid) " +
            "FROM earning e " +
            "WHERE DATE_TRUNC('year', e.payday) = DATE_TRUNC('year', now())", nativeQuery = true)
    BigDecimal getTotalLastYear();

}
