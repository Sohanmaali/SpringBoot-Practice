package com.jwt.springjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/welcome")

    public String Welcome() {
        int c = 5;
        System.out.println(5 + "=======");
        return "this page is good";
    }
}
