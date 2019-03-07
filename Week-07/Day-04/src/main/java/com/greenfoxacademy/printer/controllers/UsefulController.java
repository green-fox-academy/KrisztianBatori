package com.greenfoxacademy.printer.controllers;

import com.greenfoxacademy.printer.models.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class UsefulController {

    private UtilityService utility;

    @Autowired
    UsefulController(UtilityService randomBackgroundColor) {
        this.utility = randomBackgroundColor;
    }

    @RequestMapping("/useful")
    public String useful() {
        return "useful";
    }

    @RequestMapping("/useful/colored")
    public String colored(Model model) {
        model.addAttribute("backgroundColor", utility.randomColor());
        return "useful";
    }

    @RequestMapping("/useful/email")
    public String email(Model model, @RequestParam(name = "email") String email) {
        model.addAttribute("email", email);
        model.addAttribute("emailColor", utility.validateEmail(email));
        return "useful";
    }

    @RequestMapping(value = "/useful/encoding/{text}, {number}")
    public String encodeCaesar(Model model, @PathVariable String text, @PathVariable String number) {
        model.addAttribute("text", utility.caesar(text, Integer.parseInt(number)));
        return "useful";
    }
}
