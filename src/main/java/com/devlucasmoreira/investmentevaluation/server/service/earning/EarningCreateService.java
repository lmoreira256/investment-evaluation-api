package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.EarningFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EarningCreateService {

    @Autowired
    private StockGetByIdService stockGetByIdService;

    @Autowired
    private EarningRepository earningRepository;

    @Autowired
    private CacheManager cacheManager;

    public EarningResponse execute(EarningRequest earningRequest) {
        Stock stock = stockGetByIdService.execute(earningRequest.getIdStock());
        Earning earning = EarningFactory.build(earningRequest, stock);

        Objects.requireNonNull(cacheManager.getCache("earningList")).clear();
        return EarningFactory.buildResponse(earningRepository.save(earning));
    }

}
