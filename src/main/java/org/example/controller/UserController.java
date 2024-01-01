package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
//@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }
    @GetMapping ("/greeting")
    String helloGreeting () {
        return "Hello! It's a greeting page from your web service (test response).";
    }

    @GetMapping ("/getBalance/{user_id}")
    Users getBalanceById (@PathVariable Long user_id){
        return userService.getBalance(user_id);
    }

    @GetMapping ("/getUser/{id}")
    Optional<Users> getUserById (@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping ("/putMoney/{id}/{income}")
    void putMoney (@PathVariable Long id, @PathVariable BigDecimal income) {
//    Optional<Users> putMoney (@PathVariable Long id, @PathVariable BigDecimal income) {
        userService.putMoney(id, income);
//        return userService.getBalance(id);
    }
}
