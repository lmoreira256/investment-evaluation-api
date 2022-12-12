package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockHistoricCreationResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockHistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.service.stock.historic.StockHistoricCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.historic.StockHistoricListService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock/historic")
public class StockHistoricResource {

    @Autowired
    private StockHistoricCreateService stockHistoricCreateService;

    @Autowired
    private StockHistoricListService stockHistoricListService;

    @Cacheable("stockHistoricList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<StockHistoricResponse>> list(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(stockHistoricListService.execute(pageable), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockHistoricCreationResponse> create() {

        return new ResponseEntity<>(stockHistoricCreateService.execute(), HttpStatus.CREATED);
    }

}
