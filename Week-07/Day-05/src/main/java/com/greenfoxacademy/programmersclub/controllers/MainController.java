package com.greenfoxacademy.programmersclub.controllers;

import com.greenfoxacademy.programmersclub.models.Drink;
import com.greenfoxacademy.programmersclub.models.Food;
import com.greenfoxacademy.programmersclub.models.Fox;
import com.greenfoxacademy.programmersclub.models.Trick;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private List<Fox> foxes = new ArrayList<>() {{
        add(
                new Fox(
                        "Mr. Fox",
                        new ArrayList<>() {{
                            add("write HTML");
                            add("code in Java");
                        }},
                        "pizza",
                        "lemonade"
                )
        );
    }};
    public String currentFoxName = "Mr. Fox";


    @RequestMapping("/")
    public String introduction(Model model) {
        model.addAttribute("fox", foxes.stream()
                .filter(fox -> fox.getName().equals(currentFoxName))
                .findFirst()
                .orElse(null));
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(Model model, @RequestParam(name = "loginName") String name) {
        this.foxes.add(new Fox(name, new ArrayList<>(), "", ""));
        this.currentFoxName = name;
        model.addAttribute("fox", foxes.stream()
                .filter(fox -> fox.getName().equals(currentFoxName))
                .findFirst()
                .orElse(null));
        return "index";
    }
}
