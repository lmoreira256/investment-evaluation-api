package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryCompleteDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningListService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningSummaryCompleteService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningSummaryForActiveService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningSummaryForMonthService;
import com.devlucasmoreira.investmentevaluation.server.service.earning.EarningSummaryTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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

    @Autowired
    private EarningSummaryForMonthService earningSummaryForMonthService;

    @Autowired
    private EarningSummaryTotalService earningSummaryTotalService;

    @Autowired
    private EarningSummaryCompleteService earningSummaryCompleteService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EarningResponse> create(@RequestBody EarningRequest earningRequest) {

        return new ResponseEntity<>(earningCreateService.execute(earningRequest), HttpStatus.CREATED);
    }

    @CrossOrigin
    @Cacheable(value = "earningList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EarningResponse>> list(@RequestParam(required = false) String active) {

        return new ResponseEntity<>(earningListService.execute(active), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "earningSummaryActive")
    @GetMapping(value = "/summary/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EarningSummaryDTO>> summaryActive(@Param("active") String active) {

        return new ResponseEntity<>(earningSummaryForActiveService.execute(active), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "earningSummaryMonth")
    @GetMapping(value = "/summary/month", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EarningSummaryDTO>> summaryMonth(@Param("month") String month) {

        return new ResponseEntity<>(earningSummaryForMonthService.execute(month), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "earningSummaryTotal")
    @GetMapping(value = "/summary/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> earningSummaryTotal() {

        return new ResponseEntity<>(earningSummaryTotalService.execute(), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "earningSummaryComplete")
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EarningSummaryCompleteDTO> earningSummaryComplete() {

        return new ResponseEntity<>(earningSummaryCompleteService.execute(), HttpStatus.OK);
    }


}
