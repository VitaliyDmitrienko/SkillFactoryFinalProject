package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.AppResponseMessage;
import org.example.service.DepositorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
@RestController
//@RequiredArgsConstructor
public class DepositorController {

    private final DepositorService depositorService;
    int successfulMethodResponse = 1;
    int failedMethodResponse = 0;


    @Autowired
    public DepositorController(DepositorService depositorService) {
        this.depositorService = depositorService;
    }

    @GetMapping("/greeting")
    String helloGreeting() {
        return "Hello! It's a greeting page from your web service (test response).";
    }

    @GetMapping("/getDepositor/{depositor_donor_id}")
    ResponseEntity<?> restGetUserById(@PathVariable Long depositor_donor_id) {
        return new ResponseEntity<>((depositorService.getUser(depositor_donor_id)), HttpStatus.OK);
    }

    @GetMapping("/getBalance/{depositor_id}")
    ResponseEntity<?> restGetBalanceById(@PathVariable Long depositor_id) {
        return new ResponseEntity<>((depositorService.getBalance(depositor_id)), HttpStatus.OK);
    }

    @PutMapping("/putMoney/{depositor_donor_id}/{income}")
    ResponseEntity<?> restPutMoney(@PathVariable Long depositor_donor_id, @PathVariable BigDecimal income) {
        depositorService.putMoney(depositor_donor_id, income);
        return new ResponseEntity<>(new AppResponseMessage(successfulMethodResponse, new Date()), HttpStatus.OK);
    }

    @PutMapping("/takeMoney/{depositor_id}/{withdraw}")
    ResponseEntity<?> restTakeMoney(@PathVariable Long depositor_id, @PathVariable BigDecimal withdraw) {
        depositorService.takeMoney(depositor_id, withdraw);
        return new ResponseEntity<>(new AppResponseMessage(successfulMethodResponse, new Date()), HttpStatus.OK);
    }

    @PutMapping("transferMoney/{depositor_donor_id}/{depositor_acceptor_id}/{transfer_balance}")
    ResponseEntity<?> restTransferMoney(@PathVariable Long depositor_donor_id, @PathVariable Long depositor_acceptor_id,
                                       @PathVariable BigDecimal transfer_balance) {
        depositorService.transferMoney(depositor_donor_id, depositor_acceptor_id, transfer_balance);
        return new ResponseEntity<>(new AppResponseMessage(successfulMethodResponse, new Date()), HttpStatus.OK);
    }

}

