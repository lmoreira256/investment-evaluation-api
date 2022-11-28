package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.exception.StockNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockGetByActiveService {

    @Autowired
    private StockRepository stockRepository;

    public Stock execute(String active) {
        return stockRepository.findByActive(active).orElseThrow(StockNotFoundException::new);
    }

}
