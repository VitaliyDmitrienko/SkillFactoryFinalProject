package org.example.controller;

import org.apache.catalina.User;
import org.example.entity.Users;
import org.example.error.AppError;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> restGetBalanceById(@PathVariable Long user_id) {
//        return userService.getBalance(user_id);
        return restGetUserById(user_id);
    }

    @GetMapping("/getUser/{user_id}")
    ResponseEntity<?> restGetUserById(@PathVariable Long user_id) {
            try {
                return new ResponseEntity<>((userService.getUser(user_id)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                        "User with id " + user_id + " not found / not exist."),
                        HttpStatus.NOT_FOUND);
            }
    }

    @PutMapping("/putMoney/{user_id}/{income}")
    ResponseEntity <?> restPutMoney(@PathVariable Long user_id, @PathVariable BigDecimal income) {
//    Optional<Users> putMoney (@PathVariable Long id, @PathVariable BigDecimal income) {
        try {
            return new ResponseEntity<> ((userService.putMoney(user_id, income)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "User with id " + user_id + " not found / not exist."),
                    HttpStatus.NOT_FOUND);
        }
//        userService.putMoney(id, income);
//        return userService.getBalance(id);
    }

//    @PutMapping("/takeMoney/{user_id}/{draw}")
//    void restTakeMoney(@PathVariable Long id, @PathVariable BigDecimal draw) {
//        userService.takeMoney(id, draw);
//    }

}
