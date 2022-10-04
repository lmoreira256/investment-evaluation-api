package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.HistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.service.historic.HistoricCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.historic.HistoricListService;
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
@RequestMapping("/historic")
public class HistoricResource {

    @Autowired
    private HistoricListService historicListService;

    @Autowired
    private HistoricCreateService historicCreateService;

    @Cacheable("historicList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<HistoricResponse>> list(
            @PageableDefault(sort = "date", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity<>(historicListService.execute(pageable), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HistoricResponse> create() {

        return new ResponseEntity<>(historicCreateService.execute(), HttpStatus.CREATED);
    }

}
