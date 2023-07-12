package com.devlucasmoreira.investmentevaluation.server.service.checkpoint;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import com.devlucasmoreira.investmentevaluation.server.repository.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointListService {

    @Autowired
    private CheckpointRepository checkpointRepository;

    public List<Checkpoint> execute() {
        return checkpointRepository.findAllByOrderByCreatedAtDesc();
    }

}