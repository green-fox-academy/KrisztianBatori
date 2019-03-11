package com.greenfoxacademy.database.repository;

import com.greenfoxacademy.database.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
