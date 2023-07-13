package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CheckpointFactory;
import com.devlucasmoreira.investmentevaluation.server.service.stock.checkpoint.StockCheckpointCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.stock.checkpoint.StockCheckpointListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock-checkpoint")
public class StockCheckpointResource {

    @Autowired
    private StockCheckpointCreateService stockCheckpointCreateService;

    @Autowired
    private StockCheckpointListService stockCheckpointListService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheckpointDTO> create() {

        return new ResponseEntity<>(CheckpointFactory
                .buildDTO(stockCheckpointCreateService.execute()), HttpStatus.CREATED);
    }

    @CrossOrigin
    @Cacheable(value = "stockCheckpointList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckpointDTO>> get() {

        return new ResponseEntity<>(CheckpointFactory
                .buildListStockChecklistDTO(stockCheckpointListService.execute()), HttpStatus.OK);
    }

}
