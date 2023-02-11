package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StockGetResponseByIdService {

    @Autowired
    private StockGetByIdService stockGetByIdService;

    public StockResponse execute(UUID id) {
        Stock stock = stockGetByIdService.execute(id);

        return StockFactory.buildResponse(stock);
    }

}
