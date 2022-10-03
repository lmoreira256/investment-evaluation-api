package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.DepositRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.DepositResponse;
import com.devlucasmoreira.investmentevaluation.server.service.deposit.DepositCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
public class DepositResource {

    @Autowired
    private DepositCreateService depositCreateService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepositResponse> create(@RequestBody DepositRequest depositRequest) {

        return new ResponseEntity<>(depositCreateService.execute(depositRequest), HttpStatus.CREATED);
    }

}
