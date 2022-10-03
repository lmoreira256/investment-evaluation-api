package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HistoricRepository extends JpaRepository<Historic, UUID> {

    @Query("SELECT h FROM Historic h ORDER BY h.date DESC")
    List<Historic> findAll();

}
