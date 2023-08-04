package com.devlucasmoreira.investmentevaluation.server.service.checkpoint.real.estate.fund;

import com.devlucasmoreira.investmentevaluation.server.domain.RealEstateFundCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.repository.RealEstateFundCheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointRealEstateFundListService {

    @Autowired
    private RealEstateFundCheckpointRepository realEstateFundCheckpointRepository;

    public List<RealEstateFundCheckpoint> execute() {
        return realEstateFundCheckpointRepository.findTop12ByOrderByCreatedAtDesc();
    }

}
