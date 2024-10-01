package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class A {
    @GetMapping("/home")
    public String test(){
        return "spring boot started";
    }
}
