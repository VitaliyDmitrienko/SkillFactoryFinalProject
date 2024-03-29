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

    @GetMapping("/getOperation/{depositorDonorId}")
    ResponseEntity<?> restGetOperationByDepositorId(@PathVariable Long depositorDonorId) {
        return new ResponseEntity<>((operationService.getOperationByDepositorId(depositorDonorId)), HttpStatus.OK);
    }

//    @GetMapping(value = {"/getOperationList/{depositorDonorId}/{beginDate}/{finishDate}",
//            "/getOperationList/{depositorDonorId}/{beginDate}",
//            "/getOperationList/{depositorDonorId}/{finishDate}",
//            "/getOperationList/{depositorDonorId}"})
//    @GetMapping ("/getOperationList/{depositorDonorId}")
    @GetMapping ("/getOperationList/{depositorDonorId}")
    ResponseEntity<?> restGetOperationByDepositorIdAndOperationDateBetween
        (@PathVariable Long depositorDonorId,
        @RequestParam (required = false) LocalDateTime beginDate,
        @RequestParam (required = false) LocalDateTime finishDate) {
//        if (beginDate != null && finishDate != null) {
            return new ResponseEntity<>((operationService.
                    getOperationByDepositorIdAndOperationDateBetween(depositorDonorId, beginDate, finishDate)),
                HttpStatus.OK);
//    }
//        else return new ResponseEntity<>((operationService.getOperationByDepositorId(depositorDonorId)),
//                HttpStatus.OK);
    }

}
