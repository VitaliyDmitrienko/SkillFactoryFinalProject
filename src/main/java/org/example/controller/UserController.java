package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

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

    @GetMapping("/getBalance/{user_id}")
    Optional<Users> restGetBalanceById(@PathVariable Long user_id) {
        return userService.getBalance(user_id);
    }

    @GetMapping("/getUser/{id}")
    ResponseEntity<Users> restGetUserById(@PathVariable Long id) {
        Users tempUser = userService.getUser(id);
        if ((tempUser == null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        else {
            try {
                return new ResponseEntity<>((userService.getUser(id)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

    @PutMapping("/putMoney/{id}/{income}")
    void restPutMoney(@PathVariable Long id, @PathVariable BigDecimal income) {
//    Optional<Users> putMoney (@PathVariable Long id, @PathVariable BigDecimal income) {
        userService.putMoney(id, income);
//        return userService.getBalance(id);
    }

    @PutMapping("/takeMoney/{id}/{draw}")
    void restTakeMoney(@PathVariable Long id, @PathVariable BigDecimal draw) {
        userService.takeMoney(id, draw);
    }

}
