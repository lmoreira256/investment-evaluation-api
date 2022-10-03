package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.HistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.service.historic.HistoricListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historic")
public class HistoricResource {

    @Autowired
    private HistoricListService historicListService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HistoricResponse>> list() {

        return new ResponseEntity<>(historicListService.execute(), HttpStatus.OK);
    }

}
