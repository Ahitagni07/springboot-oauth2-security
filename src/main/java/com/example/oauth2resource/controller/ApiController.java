package com.example.oauth2resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello, public endpoint!";
    }

    @GetMapping("/api/hello")
    public String privateHello() {
        return "Hello, private endpoint!";
    }
}
