package com.greenfoxacademy.springtable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {

    @RequestMapping("/login")
    public String makeLogin() {
        return "login";
    }
}
