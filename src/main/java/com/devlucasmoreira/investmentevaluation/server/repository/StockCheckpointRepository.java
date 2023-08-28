package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.StockCheckpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockCheckpointRepository extends JpaRepository<StockCheckpoint, UUID> {

    List<StockCheckpoint> findTop30ByOrderByCreatedAtDesc();

}
