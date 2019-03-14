package com.greenfoxacademy.redditcopy.repository;

import com.greenfoxacademy.redditcopy.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
