package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningSummaryResponse;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningListService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningSummaryService;
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
@RequestMapping("/earning")
public class EarningResource {

    @Autowired
    private EarningCreateService earningCreateService;

    @Autowired
    private EarningListService earningListService;

    @Autowired
    private EarningSummaryService earningSummaryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EarningResponse> create(@RequestBody EarningRequest earningRequest) {

        return new ResponseEntity<>(earningCreateService.execute(earningRequest), HttpStatus.CREATED);
    }

    @Cacheable(value = "earningList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<EarningResponse>> list(
            @RequestParam(required = false) String active,
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(earningListService.execute(active, pageable), HttpStatus.OK);
    }

    @Cacheable(value = "earningSummary")
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EarningSummaryResponse> summary() {

        return new ResponseEntity<>(earningSummaryService.execute(), HttpStatus.OK);
    }

}
