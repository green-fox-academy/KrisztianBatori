package com.greenfoxacademy.mysql.controllers;

import com.greenfoxacademy.mysql.models.Todo;
import com.greenfoxacademy.mysql.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value={"", "/", "/list"})
    public String list(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todolist";
    }

    @RequestMapping(value="/todo")
    public String list(Model model, @RequestParam boolean isActive) {

        model.addAttribute("todos", StreamSupport
                .stream(todoRepository.findAll().spliterator(), false)
                .filter(todo -> todo.isDone() == !isActive)
                .collect(Collectors.toList()));

        return "todolist";
    }

    @GetMapping(value="/add")
    public String add(Model model) {
        model.addAttribute("todo", new Todo());
        return "newtodo";
    }

    @PostMapping(value="/add")
    public String add(@ModelAttribute(name = "todo") Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo";
    }

    @PostMapping(value="{id}/delete")
    public String delete(@PathVariable long id) {
        todoRepository.delete(todoRepository.findById(id).orElse(new Todo()));
        return "redirect:/todo";
    }

    @GetMapping(value="{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todoId", id);
        return "edittodo";
    }

    @PostMapping(value="{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute(name = "todo") Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo";
    }
}
