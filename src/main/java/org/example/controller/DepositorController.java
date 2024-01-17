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

    @Autowired
    public DepositorController (DepositorService depositorService) {
        this.depositorService = depositorService;
    }

    @GetMapping("/greeting")
    String helloGreeting() {
        return "Hello! It's a greeting page from your web service (test response).";
    }

    @GetMapping("/getDepositor/{depositor_id}")
    ResponseEntity<?> restGetUserById(@PathVariable Long depositor_id) {
        return new ResponseEntity<>((depositorService.getUser(depositor_id)), HttpStatus.OK);
    }

    @GetMapping("/getBalance/{depositor_id}")
    ResponseEntity<?> restGetBalanceById(@PathVariable Long depositor_id) {
        return new ResponseEntity<>((depositorService.getBalance(depositor_id)), HttpStatus.OK);
    }

    @PutMapping("/putMoney/{user_id}/{income}")
    ResponseEntity <?> restPutMoney(@PathVariable Long user_id, @PathVariable BigDecimal income) {
        depositorService.putMoney(user_id, income);
        return new ResponseEntity<> (new AppResponseMessage(1, new Date()), HttpStatus.OK);
    }

    @PutMapping("/takeMoney/{depositor_id}/{draw}")
    ResponseEntity <?> restTakeMoney(@PathVariable Long depositor_id, @PathVariable BigDecimal draw) {
        String successfulMethodResponse = "1";
        depositorService.takeMoney(depositor_id, draw);
        return new ResponseEntity<> (new AppResponseMessage(1, new Date()), HttpStatus.OK);
    }

}
