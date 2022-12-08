package com.example.studentappnew_backend.controller;

import com.example.studentappnew_backend.dao.StudentDao;
import com.example.studentappnew_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao dao;

    @GetMapping("/")
    public String Homepage() {
        return "Welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addstudent", consumes = "application/json", produces = "application/json")
    public String addstudentpage(@RequestBody Students s) {
        System.out.println(s.getName().toString());
        return "Student added successfully";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewstudent")
    public List<Students> viewstudents() {
        return (List<Students>) dao.findAll();
    }
}
