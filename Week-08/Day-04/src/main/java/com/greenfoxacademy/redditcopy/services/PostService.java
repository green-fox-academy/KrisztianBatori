package com.greenfoxacademy.redditcopy.services;

import com.greenfoxacademy.redditcopy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostRepository getPostRepository() {
        return postRepository;
    }
}
