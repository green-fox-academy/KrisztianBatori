package com.greenfoxacademy.redditcopy;

import com.greenfoxacademy.redditcopy.models.Post;
import com.greenfoxacademy.redditcopy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditcopyApplication {

    private PostRepository postRepository;

    @Autowired
    public RedditcopyApplication(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedditcopyApplication.class, args);
    }

}
