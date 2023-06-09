package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningListService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningSummaryForActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/earning")
public class EarningResource {

    @Autowired
    private EarningCreateService earningCreateService;

    @Autowired
    private EarningListService earningListService;

    @Autowired
    private EarningSummaryForActiveService earningSummaryForActiveService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EarningResponse> create(@RequestBody EarningRequest earningRequest) {

        return new ResponseEntity<>(earningCreateService.execute(earningRequest), HttpStatus.CREATED);
    }

    @CrossOrigin
    @Cacheable(value = "earningList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<EarningResponse>> list(
            @RequestParam(required = false) String active,
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(earningListService.execute(active, pageable), HttpStatus.OK);
    }

    @Cacheable(value = "earningSummaryActive")
    @GetMapping(value = "/summary/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EarningSummaryActiveDTO>> summaryActive() {

        return new ResponseEntity<>(earningSummaryForActiveService.execute(), HttpStatus.OK);
    }

}
