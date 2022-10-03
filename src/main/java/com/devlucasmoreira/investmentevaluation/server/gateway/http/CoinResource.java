package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.CoinRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;
import com.devlucasmoreira.investmentevaluation.server.service.coin.CoinCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin")
public class CoinResource {

    @Autowired
    private CoinCreateService coinCreateService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinResponse> create(@RequestBody CoinRequest coinRequest) {

        return new ResponseEntity<>(coinCreateService.execute(coinRequest), HttpStatus.CREATED);
    }

}
