package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.DepositRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.DepositResponse;
import com.devlucasmoreira.investmentevaluation.server.service.deposit.DepositCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.deposit.DepositListService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
public class DepositResource {

    @Autowired
    private DepositCreateService depositCreateService;

    @Autowired
    private DepositListService depositListService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepositResponse> create(@RequestBody DepositRequest depositRequest) {

        return new ResponseEntity<>(depositCreateService.execute(depositRequest), HttpStatus.CREATED);
    }

    @Cacheable(value = "depositList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<DepositResponse>> list(
            @PageableDefault(sort = "date", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(depositListService.execute(pageable), HttpStatus.OK);
    }

}
