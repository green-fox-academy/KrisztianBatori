package com.greenfoxacademy.springtable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class NewsletterController {

    @RequestMapping("/newsletter")
    public String makeSignUp() {
        return "frontend";
    }
}
