package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.exception.StockNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class StockUpdateService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private StockUpdateValuesService stockUpdateValuesService;

    public Stock execute(UUID id, StockRequest stockRequest) {
        Stock stock = stockRepository.findById(id).orElseThrow(StockNotFoundException::new);
        stock.setAmount(stockRequest.getAmount());
        stock.setDescription(stockRequest.getDescription());
        stock.setCurrentValue(stockRequest.getCurrentValue());
        stock.setPurchaseValue(stockRequest.getPurchaseValue());
        stock.setAveragePurchase(stockRequest.getAveragePurchase());

        Objects.requireNonNull(cacheManager.getCache("stockList")).clear();
        Objects.requireNonNull(cacheManager.getCache("generalSummary")).clear();
        return stockRepository.save(stockUpdateValuesService.execute(stock));
    }

}
