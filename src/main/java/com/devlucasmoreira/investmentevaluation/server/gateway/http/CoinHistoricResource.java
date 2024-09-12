package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinHistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.service.coin.historic.CoinHistoricCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.coin.historic.CoinHistoricListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin/historic")
public class CoinHistoricResource {

    @Autowired
    private CoinHistoricListService coinHistoricListService;

    @Autowired
    private CoinHistoricCreateService coinHistoricCreateService;

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CoinHistoricResponse>> list(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(coinHistoricListService.execute(pageable), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinHistoricResponse> create() {

        return new ResponseEntity<>(coinHistoricCreateService.execute(), HttpStatus.CREATED);
    }

}
