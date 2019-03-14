package com.greenfoxacademy.redditcopy.controllers;

import com.greenfoxacademy.redditcopy.models.Post;
import com.greenfoxacademy.redditcopy.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String showMainPage(Model model) {
        model.addAttribute("posts", postService.getPostRepository().findAll());
        return "index";
    }

    @GetMapping("/addPost")
    public String showAddPostPage(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @PostMapping("/addPost")
    public String showAddPostPage(@ModelAttribute(name = "post") Post post) {
        postService.getPostRepository().save(post);
        return "redirect:/greddit/";
    }


}
