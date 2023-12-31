package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
//@RequiredArgsConstructor
public class WebController {

    private final UserService userService;

    @Autowired
    public WebController (UserService userService) {
        this.userService = userService;
    }
    @GetMapping ("/greeting")
    String helloGreeting () {
        return "Hello! It's a greeting page from your web service (test response).";
    }

    @GetMapping ("/getBalance/{user_id}")
    Users getBalanceById (Long user_id){
        return userService.getBalance(user_id);
    }

}
