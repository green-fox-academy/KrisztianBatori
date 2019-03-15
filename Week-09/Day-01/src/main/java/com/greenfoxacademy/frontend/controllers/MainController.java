package com.greenfoxacademy.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
