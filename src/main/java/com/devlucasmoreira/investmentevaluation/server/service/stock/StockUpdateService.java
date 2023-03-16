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

        if (stockRequest.getAmount() != null) {
            stock.setAmount(stockRequest.getAmount());
        }

        if (stockRequest.getDescription() != null) {
            stock.setDescription(stockRequest.getDescription());
        }

        if (stockRequest.getCurrentValue() != null) {
            stock.setCurrentValue(stockRequest.getCurrentValue());
        }

        if (stockRequest.getPurchaseValue() != null) {
            stock.setPurchaseValue(stockRequest.getPurchaseValue());
        }

        if (stockRequest.getAveragePurchase() != null) {
            stock.setAveragePurchase(stockRequest.getAveragePurchase());
        }

        stock = stockUpdateValuesService.execute(stock);

        Objects.requireNonNull(cacheManager.getCache("stockList")).clear();
        return stockRepository.save(stock);
    }

}
