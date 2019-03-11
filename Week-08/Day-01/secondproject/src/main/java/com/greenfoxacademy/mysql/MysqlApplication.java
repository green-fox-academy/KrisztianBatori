package com.greenfoxacademy.mysql;

import com.greenfoxacademy.mysql.models.Todo;
import com.greenfoxacademy.mysql.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MysqlApplication implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*todoRepository.save(new Todo("Start the day", true, true));
        todoRepository.save(new Todo("Finish H2 workshop1", true, false));
        todoRepository.save(new Todo("Finish JPA workshop2", true, false));
        todoRepository.save(new Todo("Create a CRUD project", false, false));*/
    }

}
