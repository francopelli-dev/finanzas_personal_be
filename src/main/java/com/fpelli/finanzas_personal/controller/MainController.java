package com.fpelli.finanzas_personal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController {
    @GetMapping("/h")
    public String helloworld() {
        return "helloworld";
    }

    @GetMapping("/healthcheck")
    public String getMethodName() {
        return "up";
    }

}
