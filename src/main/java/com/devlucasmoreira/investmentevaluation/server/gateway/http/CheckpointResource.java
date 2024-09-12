package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CheckpointFactory;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.CheckpointCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.general.CheckpointGeneralListService;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.real.estate.fund.CheckpointRealEstateFundListService;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.stock.CheckpointStockListService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/checkpoint")
public class CheckpointResource {

    @Autowired
    private CheckpointCreateService checkpointCreateService;

    @Autowired
    private CheckpointGeneralListService checkpointGeneralListService;

    @Autowired
    private CheckpointStockListService checkpointStockListService;

    @Autowired
    private CheckpointRealEstateFundListService checkpointRealEstateFundListService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckpointDTO>> create() {

        return new ResponseEntity<>(checkpointCreateService.execute(), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckpointDTO>> get() {

        return new ResponseEntity<>(CheckpointFactory.buildListDTO(checkpointGeneralListService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckpointDTO>> getStockList() {

        return new ResponseEntity<>(CheckpointFactory
                .buildListStockCheckpointDTO(checkpointStockListService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/real-estate-fund", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckpointDTO>> getRealEstateFundList() {

        return new ResponseEntity<>(CheckpointFactory
                .buildListRealEstateFundCheckpointDTO(checkpointRealEstateFundListService.execute()), HttpStatus.OK);
    }

}
