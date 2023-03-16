package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.exception.StockAlreadyExistsException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StockCreateService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private StockUpdateValuesService stockUpdateValuesService;

    public Stock execute(StockRequest stockRequest) {
        validateStock(stockRequest);

        Stock stock = StockFactory.build(stockRequest);
        stock = stockUpdateValuesService.execute(stock);

        Objects.requireNonNull(cacheManager.getCache("stockList")).clear();
        return stockRepository.save(stock);
    }

    private void validateStock(StockRequest stockRequest) {
        if (stockRepository.existsByActive(stockRequest.getActive())) {
            throw new StockAlreadyExistsException();
        }
    }

}
