package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getOperationList/{depositor_id}/{begin_date}/{finish_date}")
    ResponseEntity<?> restGetOperationByDepositorIdAndBetweenDates
    (@PathVariable Long depositor_id,
     @PathVariable LocalDateTime begin_date,
            @PathVariable LocalDateTime finish_date) {
//             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("begin_date") LocalDateTime begin_date,
//             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("finish_date") LocalDateTime finish_date) {

        return new ResponseEntity<>((operationService.
                getOperationByDepositorIdAndBetweenDates(depositor_id, begin_date, finish_date)),
                HttpStatus.OK);
    }

}
