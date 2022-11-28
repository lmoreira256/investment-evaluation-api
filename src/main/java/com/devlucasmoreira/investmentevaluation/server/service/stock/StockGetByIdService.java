package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.exception.StockNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StockGetByIdService {

    @Autowired
    private StockRepository stockRepository;

    public Stock execute(UUID id) {
        return stockRepository.findById(id).orElseThrow(StockNotFoundException::new);
    }

}
