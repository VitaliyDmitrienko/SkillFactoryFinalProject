package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.AppErrorMessage;
import org.example.exception.AppResponseMessage;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
@RestController
//@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    String helloGreeting() {
        return "Hello! It's a greeting page from your web service (test response).";
    }

    @GetMapping("/getUser/{user_id}")
    ResponseEntity<?> restGetUserById(@PathVariable Long user_id) {
        return new ResponseEntity<>((userService.getUser(user_id)), HttpStatus.OK);
    }

    @GetMapping("/getBalance/{user_id}")
    ResponseEntity<?> restGetBalanceById(@PathVariable Long user_id) {
        return restGetUserById(user_id);
    }

    @PutMapping("/putMoney/{user_id}/{income}")
    ResponseEntity <?> restPutMoney(@PathVariable Long user_id, @PathVariable BigDecimal income) {
        userService.putMoney(user_id, income);
        return new ResponseEntity<> (new AppResponseMessage(1, new Date()), HttpStatus.OK);
    }

    @PutMapping("/takeMoney/{user_id}/{draw}")
    ResponseEntity <?> restTakeMoney(@PathVariable Long user_id, @PathVariable BigDecimal draw) {
        String successfulMethodResponse = "1";
        userService.takeMoney(user_id, draw);
        return new ResponseEntity<> (new AppResponseMessage(1, new Date()), HttpStatus.OK);
    }

}
