package com.example.jardemo.controller;

import com.example.jardemo.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("http://localhost:3000")
public class PersonController {
    @RequestMapping("/person")
    @ResponseBody
    public Person testAction() {
        return new Person("John", "Doe", 33);
    }
}
