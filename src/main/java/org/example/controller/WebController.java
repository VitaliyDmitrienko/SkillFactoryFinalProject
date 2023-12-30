package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebController {
    @GetMapping ("/greeting")
    String helloGreeting () {
        return "Hello! It's a greeting page from your web service (test response).";
    }

}
