package com.devlucasmoreira.investmentevaluation.server.service.stock.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.StockHistoric;
import com.devlucasmoreira.investmentevaluation.server.enums.StockHistoricTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockHistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockHistoricCreationResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.StockHistoricRepository;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetTotalActualValueByTypeService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetTotalAmountByTypeService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetTotalPurchaseValueByTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

@Service
public class StockHistoricCreateService {

    @Autowired
    private StockHistoricRepository stockHistoricRepository;

    @Autowired
    private StockGetTotalAmountByTypeService stockGetTotalAmountByTypeService;

    @Autowired
    private StockGetTotalPurchaseValueByTypeService stockGetTotalPurchaseValueByTypeService;

    @Autowired
    private StockGetTotalActualValueByTypeService stockGetTotalActualValueByTypeService;

    @Autowired
    private CacheManager cacheManager;

    public StockHistoricCreationResponse execute() {
        StockHistoric stockHistoricStock = createStockHistoric(StockTypeEnum.STOCK, StockHistoricTypeEnum.STOCK);
        StockHistoric stockHistoricRealEstateFund = createStockHistoric(StockTypeEnum.REAL_ESTATE_FUND, StockHistoricTypeEnum.REAL_ESTATE_FUND);
        StockHistoric stockHistoricGeneral = createGeneralStockHistoric(stockHistoricStock, stockHistoricRealEstateFund);

        Objects.requireNonNull(cacheManager.getCache("stockHistoricList")).clear();
        return StockHistoricFactory.buildResponse(Arrays.asList(stockHistoricStock, stockHistoricRealEstateFund, stockHistoricGeneral));
    }

    private StockHistoric createStockHistoric(StockTypeEnum stockTypeEnum, StockHistoricTypeEnum stockHistoricTypeEnum) {
        Integer amount = stockGetTotalAmountByTypeService.execute(stockTypeEnum);
        BigDecimal purchaseValue = stockGetTotalPurchaseValueByTypeService.execute(stockTypeEnum);
        BigDecimal actualValue = stockGetTotalActualValueByTypeService.execute(stockTypeEnum);

        return stockHistoricRepository.save(StockHistoricFactory.build(actualValue, purchaseValue, amount, stockHistoricTypeEnum));
    }

    private StockHistoric createGeneralStockHistoric(StockHistoric stockHistoricStock, StockHistoric stockHistoricRealEstateFund) {
        Integer amount = stockHistoricStock.getAmount() + stockHistoricRealEstateFund.getAmount();
        BigDecimal purchaseValue = stockHistoricStock.getPurchaseValue().add(stockHistoricRealEstateFund.getPurchaseValue());
        BigDecimal actualValue = stockHistoricStock.getActualValue().add(stockHistoricRealEstateFund.getActualValue());

        return stockHistoricRepository.save(StockHistoricFactory.build(actualValue, purchaseValue, amount, StockHistoricTypeEnum.GENERAL));
    }

}
