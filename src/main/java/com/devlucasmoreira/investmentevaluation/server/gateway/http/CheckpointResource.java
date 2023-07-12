package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CheckpointFactory;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.CheckpointCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.CheckpointListService;
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
@RequestMapping("/checkpoint")
public class CheckpointResource {

    @Autowired
    private CheckpointCreateService checkpointCreateService;

    @Autowired
    private CheckpointListService checkpointListService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheckpointDTO> create() {

        return new ResponseEntity<>(CheckpointFactory.buildDTO(checkpointCreateService.execute()), HttpStatus.CREATED);
    }

    @CrossOrigin
    @Cacheable(value = "checkpointList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckpointDTO>> get() {

        return new ResponseEntity<>(CheckpointFactory.buildListDTO(checkpointListService.execute()), HttpStatus.OK);
    }

}
