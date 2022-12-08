package com.example.studentappnew_backend.controller;

import com.example.studentappnew_backend.dao.StudentDao;
import com.example.studentappnew_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public String addstudent(@RequestBody Students s) {
        System.out.println(s.getName().toString());
        dao.save(s);
        return "Student added successfully";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewstudent")
    public List<Students> viewstudents() {
        return (List<Students>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/searchstudent", consumes = "application/json", produces = "application/json")
    public List<Students> searchstudent(@RequestBody Students s){
        String name = String.valueOf(s.getName()) ;
        System.out.println(name);
        return (List<Students>) dao.SearchStudent(s.getName());
    }

    @CrossOrigin
    @PostMapping(path= "/deletestudent", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> deletestudent(@RequestBody Students s){
        String studentid=String.valueOf(s.getId());
        System.out.println(studentid);
        dao.DeleteStudent(s.getId());
        HashMap<String ,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
