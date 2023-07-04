package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActiveRepository extends JpaRepository<Active, UUID> {

    boolean existsByName(String name);

    @Query("SELECT a FROM Active a WHERE a.enabled = true ORDER BY a.name ASC")
    List<Active> listEnabled();

    @Query("SELECT a FROM Active a WHERE UPPER(a.name) LIKE %:name%")
    Optional<Active> findByName(@Param("name") String name);

    @Query("SELECT SUM(a.amount) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    Integer getTotalAmountByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.purchaseValue) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalPurchaseValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.currentValue) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalCurrentValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.resultValue) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalResultValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.resultPercentageValue) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalResulPercentageValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT a FROM Active a WHERE a.enabled = true AND a.activeType = :activeTypeEnum ORDER BY a.name ASC")
    List<Active> listActiveByType(@Param("activeTypeEnum") ActiveTypeEnum activeTypeEnum);

}
