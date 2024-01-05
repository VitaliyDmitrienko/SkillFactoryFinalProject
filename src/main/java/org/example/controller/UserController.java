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
    Optional<Users> restGetBalanceById(@PathVariable Long user_id) {
        return userService.getBalance(user_id);
    }

    @GetMapping("/getUser/{id}")
    ResponseEntity<?> restGetUserById(@PathVariable Long id) {
//        Users temp/ser = userService.getUser(id);
//        if ((tempUser == null)) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
//        else {
            try {
                return new ResponseEntity<Users>((userService.getUser(id)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                        "User with id " + id + " not found / not exist."),
                        HttpStatus.NOT_FOUND);
            }
//        }
    }

    @PutMapping("/putMoney/{id}/{income}")
    ResponseEntity <Optional<Users>> restPutMoney(@PathVariable Long id, @PathVariable BigDecimal income) {
//    Optional<Users> putMoney (@PathVariable Long id, @PathVariable BigDecimal income) {
        try {
            return new ResponseEntity<Optional<Users>> ((userService.putMoney(id, income)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        userService.putMoney(id, income);
//        return userService.getBalance(id);
    }

    @PutMapping("/takeMoney/{id}/{draw}")
    void restTakeMoney(@PathVariable Long id, @PathVariable BigDecimal draw) {
        userService.takeMoney(id, draw);
    }

}
