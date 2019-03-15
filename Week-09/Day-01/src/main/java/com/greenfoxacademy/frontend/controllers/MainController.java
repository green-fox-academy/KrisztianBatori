package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.greenfoxacademy.frontend.models.Doubling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.OptionalInt;

@RestController
public class MainController {

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/doubling")
    public ObjectNode getDouble(@RequestParam(name = "input", required = false) Integer input) {
        if (input == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Please provide an input!");
            return objectNode;
        }
        else {
            return new ObjectMapper().valueToTree(
                    new Doubling(input, input * 2)
            );
        }
    }
}
