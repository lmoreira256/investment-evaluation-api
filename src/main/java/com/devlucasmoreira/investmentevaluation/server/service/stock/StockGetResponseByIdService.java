package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StockGetResponseByIdService {

    @Autowired
    private StockGetByIdService stockGetByIdService;

    public Stock execute(UUID id) {
        return stockGetByIdService.execute(id);
    }

}
