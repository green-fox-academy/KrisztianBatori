package com.greenfoxacademy.redditcopy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greddit")
public class GredditController {

    @GetMapping({"", "/"})
    public String showMainPage() {
        return "index";
    }



}
