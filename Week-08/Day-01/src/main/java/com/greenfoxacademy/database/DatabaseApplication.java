package com.greenfoxacademy.database;

import com.greenfoxacademy.database.models.Todo;
import com.greenfoxacademy.database.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("Start the day", true, true));
        todoRepository.save(new Todo("Finish H2 workshop1", true, false));
        todoRepository.save(new Todo("Finish JPA workshop2", true, false));
        todoRepository.save(new Todo("Create a CRUD project", false, false));
    }
}
