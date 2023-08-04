package com.devlucasmoreira.investmentevaluation.server.service.checkpoint.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.StockCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.repository.StockCheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointStockListService {

    @Autowired
    private StockCheckpointRepository stockCheckpointRepository;

    public List<StockCheckpoint> execute() {
        return stockCheckpointRepository.findTop12ByOrderByCreatedAtDesc();
    }

}
