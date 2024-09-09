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

    @Query("SELECT SUM(a.quantity) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    Integer getTotalQuantityByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.costValue) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalCostValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.currentValue) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalCurrentValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT SUM(a.netResult) FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalNetResultByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT ((SUM(a.currentValue) - SUM(a.costValue)) / SUM(a.costValue)) * 100 FROM Active a WHERE a.activeType IN (:activeTypeList) AND a.enabled = true")
    BigDecimal getTotalResulPercentageValueByType(@Param("activeTypeList") List<ActiveTypeEnum> activeTypeList);

    @Query("SELECT a FROM Active a WHERE a.enabled = true AND a.activeType = :activeTypeEnum ORDER BY a.name ASC")
    List<Active> listActiveByType(@Param("activeTypeEnum") ActiveTypeEnum activeTypeEnum);

}
