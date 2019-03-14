package com.greenfoxacademy.redditcopy.controllers;

import com.greenfoxacademy.redditcopy.models.Post;
import com.greenfoxacademy.redditcopy.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/upvotePost/{id}")
    public String upvotePost(@PathVariable long id) {
        Post modifiedPost = postService.getPostRepository().findById(id).orElse(null);
        modifiedPost.setPostTotalUpvotes(modifiedPost.getPostTotalUpvotes() + 1);
        modifiedPost.setPostTotalVotes(modifiedPost.getPostTotalVotes() + 1);
        postService.getPostRepository().save(modifiedPost);
        return "redirect:/greddit/";
    }

    @GetMapping(value = "/downvotePost/{id}")
    public String downvotePost(@PathVariable long id) {
        Post modifiedPost = postService.getPostRepository().findById(id).orElse(null);
        modifiedPost.setPostTotalDownvotes(modifiedPost.getPostTotalDownvotes() + 1);
        modifiedPost.setPostTotalVotes(modifiedPost.getPostTotalVotes() - 1);
        postService.getPostRepository().save(modifiedPost);
        return "redirect:/greddit/";
    }

    @GetMapping(value = "/showPost/{id}")
    public String downvotePost(Model model, @PathVariable() long id) {
        model.addAttribute("gifName", postService.getPostRepository().findById(id).orElse(null).getPostUrl());
        return "showpost";
    }


}
