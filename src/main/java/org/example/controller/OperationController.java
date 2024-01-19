package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class OperationController {
    private final OperationService operationService;

    @Autowired
    public OperationController (OperationService operationService) {
        this.operationService=operationService;
    }

    @GetMapping("/getOperation/{depositor_id}")
    ResponseEntity<?> restGetOperationByDepositorId(@PathVariable Long depositor_id) {
        return new ResponseEntity<>((operationService.getOperationByDepositorId(depositor_id)), HttpStatus.OK);
    }

    @GetMapping(value = {"/getOperationList/{depositor_id}/{begin_date}/{finish_date}",
            "/getOperationList/{depositor_id}/{begin_date}",
            "/getOperationList/{depositor_id}/{finish_date}",
            "/getOperationList/{depositor_id}"})
    ResponseEntity<?> restGetOperationByDepositorIdAndBetweenDates
        (@PathVariable (required = true) Long depositor_id,
        @PathVariable (required = false) LocalDateTime begin_date,
        @PathVariable (required = false) LocalDateTime finish_date) {

//        System.out.println(depositor_id);
//        if (begin_date != null) System.out.println(begin_date);
//        if (finish_date != null) System.out.println(finish_date);
        if (begin_date != null && finish_date != null) {
            return new ResponseEntity<>((operationService.
                    getOperationByDepositorIdAndBetweenDates(depositor_id, begin_date, finish_date)),
                HttpStatus.OK);}
        else return new ResponseEntity<>((operationService.getOperationByDepositorId(depositor_id)), HttpStatus.OK);

//        return new ResponseEntity<>(HttpStatus.OK);
    }

    }
