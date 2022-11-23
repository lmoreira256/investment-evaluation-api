package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockResource {

    @Autowired
    private StockCreateService stockCreateService;

    @Autowired
    private StockListService stockListService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> create(@RequestBody StockRequest stockRequest) {

        return new ResponseEntity<>(stockCreateService.execute(stockRequest), HttpStatus.CREATED);
    }

    @Cacheable(value = "stockList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<StockResponse>> list(
            @RequestParam(required = false) String active,
            @PageableDefault(sort = "currentValue", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(stockListService.execute(active, pageable), HttpStatus.OK);
    }

}
