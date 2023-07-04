package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetGeneralSummaryService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetRealEstateFundSummaryService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetResponseByIdService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetStockSummaryService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockListService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stock")
public class StockResource {

    @Autowired
    private StockCreateService stockCreateService;

    @Autowired
    private StockListService stockListService;

    @Autowired
    private StockUpdateService stockUpdateService;

    @Autowired
    private StockGetResponseByIdService stockGetResponseByIdService;

    @Autowired
    private StockGetGeneralSummaryService stockGetGeneralSummaryService;

    @Autowired
    private StockGetStockSummaryService stockGetStockSummaryService;

    @Autowired
    private StockGetRealEstateFundSummaryService stockGetRealEstateFundSummaryService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> create(@RequestBody StockRequest stockRequest) {

        return new ResponseEntity<>(StockFactory.buildResponse(stockCreateService.execute(stockRequest)), HttpStatus.CREATED);
    }

    @CrossOrigin
    @Cacheable(value = "stockList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockResponse>> list() {

        return new ResponseEntity<>(StockFactory.buildPageResponse(stockListService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> update(@PathVariable("id") UUID id, @RequestBody StockRequest stockRequest) {

        return new ResponseEntity<>(StockFactory.buildResponse(stockUpdateService.execute(id, stockRequest)), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> get(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(StockFactory.buildResponse(stockGetResponseByIdService.execute(id)), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "generalSummary")
    @GetMapping(value = "/general-summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveSummaryDTO> getGeneralSummary() {

        return new ResponseEntity<>(stockGetGeneralSummaryService.execute(), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "stockSummary")
    @GetMapping(value = "/stock-summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveSummaryDTO> getStockSummary() {

        return new ResponseEntity<>(stockGetStockSummaryService.execute(), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "realEstateFundSummary")
    @GetMapping(value = "/real-estate-fund-summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveSummaryDTO> getRealEstateFundSummary() {

        return new ResponseEntity<>(stockGetRealEstateFundSummaryService.execute(), HttpStatus.OK);
    }

}
