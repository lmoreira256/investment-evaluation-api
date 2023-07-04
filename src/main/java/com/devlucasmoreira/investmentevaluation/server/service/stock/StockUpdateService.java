package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.exception.StockNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StockUpdateService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockUpdateValuesService stockUpdateValuesService;

    @Autowired
    private StockCleanCacheService stockCleanCacheService;

    public Stock execute(UUID id, StockRequest stockRequest) {
        Stock stock = stockRepository.findById(id).orElseThrow(StockNotFoundException::new);
        stock.setAmount(stockRequest.getAmount());
        stock.setDescription(stockRequest.getDescription());
        stock.setCurrentValue(stockRequest.getCurrentValue());
        stock.setPurchaseValue(stockRequest.getPurchaseValue());
        stock.setAveragePurchase(stockRequest.getAveragePurchase());

        stockCleanCacheService.execute();
        return stockRepository.save(stockUpdateValuesService.execute(stock));
    }

}
