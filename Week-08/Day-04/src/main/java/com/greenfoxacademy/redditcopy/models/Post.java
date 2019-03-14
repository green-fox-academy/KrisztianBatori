package com.greenfoxacademy.redditcopy.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    private String postTitle;
    private int postTotalVotes;
    private int postTotalUpvotes;
    private int postTotalDownvotes;
    private String postUrl;

    public Post() {

    }
}
