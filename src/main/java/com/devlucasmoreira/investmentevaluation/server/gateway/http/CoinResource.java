package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.CoinRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;
import com.devlucasmoreira.investmentevaluation.server.service.coin.CoinCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.coin.CoinListService;
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
@RequestMapping("/coin")
public class CoinResource {

    @Autowired
    private CoinCreateService coinCreateService;

    @Autowired
    private CoinListService coinListService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinResponse> create(@RequestBody CoinRequest coinRequest) {

        return new ResponseEntity<>(coinCreateService.execute(coinRequest), HttpStatus.CREATED);
    }

    @Cacheable(value = "coinList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CoinResponse>> list(
            @RequestParam(required = false) String name,
            @PageableDefault(sort = "currentValue", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(coinListService.execute(name, pageable), HttpStatus.OK);
    }

}
