package com.devlucasmoreira.investmentevaluation.server.repository;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, UUID> {

    List<Checkpoint> findTop30ByOrderByCreatedAtDesc();

}
