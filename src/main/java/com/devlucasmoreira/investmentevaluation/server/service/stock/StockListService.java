package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockListService {

    @Autowired
    private StockRepository stockRepository;

    public Page<StockResponse> execute(String active, Pageable pageable) {
        Page<Stock> stockPage = active == null || active.length() == 0
                ? stockRepository.findByShow(true, pageable) : stockRepository.findByActive(active.toUpperCase(), pageable);

        return StockFactory.buildPageResponse(stockPage);
    }

}
