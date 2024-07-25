package com.example.jardemo.controller;

import com.example.jardemo.domain.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @RequestMapping("/person")
    public Person testAction() {
        new Person("John", "Doe", 33);
        return new Person("John", "Doe", 33);
    }
}
