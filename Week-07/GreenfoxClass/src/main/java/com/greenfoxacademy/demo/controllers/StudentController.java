package com.greenfoxacademy.demo.controllers;

import com.greenfoxacademy.demo.models.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller

public class StudentController {

    private StudentService students;

    @Autowired
    StudentController(StudentService students) {
        this.students = students;
    }


    @RequestMapping("/gfa")
    public String listStudentOrdered(Model model) {
        model.addAttribute("students", students.findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList()));
        model.addAttribute("studentCount", students.count());
        return "student";
    }

    @RequestMapping("/gfa/list")
    public String listStudentFirst(Model model) {
        model.addAttribute("students", students.findAll());
        model.addAttribute("studentCount", students.count());
        return "student";
    }

    @RequestMapping("/gfa/add")
    public String addStudent(Model model, @RequestParam(name = "student") String student) {
        students.save(student);
        model.addAttribute("students", students.findAll());
        model.addAttribute("studentCount", students.count());
        return "student";
    }

    @RequestMapping("/gfa/check")
    public String checkStudent(Model model, @RequestParam(name = "student") String student) {
        if (students.findAll().contains(student)) {
            model.addAttribute("result", "The student " + student + " is in the list!");
        }
        else {
            model.addAttribute("result", "The student " + student + " is NOT in the list!");
        }
        model.addAttribute("students", students.findAll());
        model.addAttribute("studentCount", students.count());
        return "student";
    }
}
