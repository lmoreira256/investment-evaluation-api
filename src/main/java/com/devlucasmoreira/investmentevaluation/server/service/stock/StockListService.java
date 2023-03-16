package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockListService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> execute() {
        return stockRepository.findByShowOrderByActiveAsc(true);
    }

}
