package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greenfoxacademy.frontend.models.ArraysResult;
import com.greenfoxacademy.frontend.models.Doubling;
import com.greenfoxacademy.frontend.models.Greet;
import com.greenfoxacademy.frontend.models.Until;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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

    @RequestMapping("/greeter")
    public ObjectNode greet(@RequestParam(name = "name", required = false) String name,
                            @RequestParam(name = "title", required = false) String title) {
        if (name == null || title == null) {

            String errorMessage;
            if (name == null && title == null) {
                errorMessage = "name and a title";
            }
            else if (name == null) {
                errorMessage = "name";
            }
            else {
                errorMessage = "title";
            }

            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", String.format("Please provide a %s!", errorMessage));
            return objectNode;
        }
        else {
            return new ObjectMapper().valueToTree(
                    new Greet(name, title)
            );
        }
    }

    @PostMapping(value = "/dountil/{action}")
    public @ResponseBody ObjectNode doUntil(@PathVariable(name = "action") String action,
                                            @RequestBody(required = false) ObjectNode until) {
        if (until == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Please provide a number!");
            return objectNode;
        }
        else {
            return new ObjectMapper().valueToTree(
                    new Until(until.findValue("until").asInt(), action)
            );
        }
    }

    @GetMapping(value = "/arrays")
    public @ResponseBody ObjectNode arrayHandler(@RequestBody(required = false) ObjectNode arrays) {
        if (arrays == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Please provide what to do with the numbers!");
            return objectNode;
        }
        else {
            String objectNodeString = arrays.findValues("numbers")
                                    .stream()
                                    .map(json -> json.toString())
                                    .collect(Collectors.toList())
                                    .get(0);

            String[] objectNodeArray = objectNodeString.substring(1, objectNodeString.length() - 1).split(",");

            return new ObjectMapper().valueToTree(
                    new ArraysResult(arrays.findValue("what").asText(),
                            Arrays.asList(objectNodeArray)
                    ));
        }
    }
}
