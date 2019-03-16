package com.greenfoxacademy.frontend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greenfoxacademy.frontend.models.*;
import com.greenfoxacademy.frontend.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class MainController {

    private LogService logService;

    @Autowired
    MainController(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        logService.saveLog(new Log(new Timestamp(new Date().getTime()), "/", "index"));
        return modelAndView;
    }

    @RequestMapping("/doubling")
    public ObjectNode getDouble(@RequestParam(name = "input", required = false) Integer input) {
        if (input == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Please provide an input!");
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/doubling",
                    String.format("input=%s", objectNode.findValue("error"))));
            return objectNode;
        }
        else {
            ObjectNode objectNode = new ObjectMapper().valueToTree(
                    new Doubling(input, input * 2)
            );

            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/doubling",
                    String.format("input=%s", objectNode.findValue("result"))));

            return objectNode;
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
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/greeter",
                    String.format("input=%s", objectNode.findValue("error"))));
            return objectNode;
        }
        else {
            ObjectNode objectNode = new ObjectMapper().valueToTree(new Greet(name, title));
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/greeter",
                    String.format("welcome_message=%s", objectNode.findValue("welcome_message"))));
            return objectNode;
        }
    }

    @GetMapping(value = "/appenda/{appendable}")
    public ObjectNode appendA(@PathVariable(name = "appendable") String appendable) {
        if (appendable == null) {
            throw new ResourceNotFoundException();
        }
        else {
            ObjectNode objectNode = new ObjectMapper().valueToTree(
                    new AppendA(appendable)
            );
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    String.format("/appenda/{%s}", appendable),
                    String.format("appended=%s", objectNode.findValue("appended"))));
            return objectNode;
        }
    }

    @PostMapping(value = "/dountil/{action}")
    public @ResponseBody ObjectNode doUntil(@PathVariable(name = "action") String action,
                                            @RequestBody(required = false) ObjectNode until) {
        if (until == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Please provide a number!");
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    String.format("/dountil/{%s}", action),
                    String.format("input=%s", objectNode.findValue("error"))));
            return objectNode;
        }
        else {
            ObjectNode objectNode = new ObjectMapper().valueToTree(
                    new Until(until.findValue("until").asInt(), action)
            );
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    String.format("/dountil/{%s}", action),
                    String.format("result=%s", objectNode.findValue("result"))));
            return objectNode;
        }
    }

    @GetMapping(value = "/arrays")
    public @ResponseBody ObjectNode arrayHandler(@RequestBody(required = false) ObjectNode arrays) {
        if (arrays == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Please provide what to do with the numbers!");
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/arrays",
                    String.format("input=%s", objectNode.findValue("error"))));
            return objectNode;
        }
        else {
            String objectNodeString = arrays.findValues("numbers")
                                    .stream()
                                    .map(json -> json.toString())
                                    .collect(Collectors.toList())
                                    .get(0);

            String[] objectNodeArray = objectNodeString.substring(1, objectNodeString.length() - 1).split(",");

            ObjectNode objectNode = new ObjectMapper().valueToTree(
                    new ArraysResult(arrays.findValue("what").asText(),
                            Arrays.asList(objectNodeArray)
                    ));

            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/arrays",
                    String.format("result=%s", objectNode.findValue("result"))));

            return objectNode;
        }
    }

    @GetMapping("/log")
    public ObjectNode collectLogEntries() {
        return new ObjectMapper().valueToTree(
                logService.collectLogs()
        );
    }

    @PostMapping(value = "/sith")
    public @ResponseBody ObjectNode doUntil(@RequestBody(required = false) ObjectNode text) {
        if (text == null) {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("error", "Feed me some text you have to, padawan young you are. Hmmm.");
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/sith",
                    String.format("sith_text=%s", objectNode.findValue("error"))));
            return objectNode;
        }
        else {
            ObjectNode objectNode = new ObjectMapper().createObjectNode();
            objectNode.put("sith_text",
                    SithTextGenerator.generateSithText(text.findValue("text").asText()));
            logService.saveLog(new Log(new Timestamp(new Date().getTime()),
                    "/sith",
                    String.format("sith_text=%s", objectNode.findValue("sith_text"))));
            return objectNode;
        }
    }
}
