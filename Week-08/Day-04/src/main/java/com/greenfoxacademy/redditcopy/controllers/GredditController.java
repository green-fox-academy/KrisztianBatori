package com.greenfoxacademy.redditcopy.controllers;

import com.greenfoxacademy.redditcopy.models.Post;
import com.greenfoxacademy.redditcopy.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greddit")
public class GredditController {

    private PostService postService;

    @Autowired
    GredditController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"", "/"})
    public String showMainPage() {
        return "index";
    }


}
