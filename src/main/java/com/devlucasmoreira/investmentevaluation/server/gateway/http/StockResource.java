package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockGetResponseByIdService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockListService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> create(@RequestBody StockRequest stockRequest) {

        return new ResponseEntity<>(stockCreateService.execute(stockRequest), HttpStatus.CREATED);
    }

    @CrossOrigin
    @Cacheable(value = "stockList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<StockResponse>> list(
            @RequestParam(required = false) String active,
            @PageableDefault(sort = "active") Pageable pageable
    ) {

        return new ResponseEntity<>(stockListService.execute(active, pageable), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "stockList")
    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockResponse>> list() {

        return new ResponseEntity<>(StockFactory.buildPageResponse(stockListService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> update(@PathVariable("id") UUID id, @RequestBody StockRequest stockRequest) {

        return new ResponseEntity<>(stockUpdateService.execute(id, stockRequest), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockResponse> get(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(stockGetResponseByIdService.execute(id), HttpStatus.OK);
    }

}
