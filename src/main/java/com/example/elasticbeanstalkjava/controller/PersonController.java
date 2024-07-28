package com.example.elasticbeanstalkjava.controller;

import com.example.elasticbeanstalkjava.domain.Person;
import com.example.elasticbeanstalkjava.service.DynamoDbService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final DynamoDbService dynamoDbService;

    public PersonController(DynamoDbService dynamoDbService) {
        this.dynamoDbService = dynamoDbService;
    }

    @RequestMapping("test")
    public String getTest(){
        return "test";
    }

    @RequestMapping("/get/{id}")
    public Person getPerson(@PathVariable int id) {
//        Person person = dynamoDbService.getPerson("John");
        dynamoDbService.getPerson(1);
        Person person2 = new Person("Jan", "Kowalski", 33);
        return person2;
    }

    @RequestMapping("/put/{firstname}/{lastname}/{age}")
    public void putPerson(@PathVariable String firstname, @PathVariable String lastname,
                          @PathVariable int age){
        Person person =  new Person(firstname, lastname, age);
        dynamoDbService.putPerson(person);
    }

    @RequestMapping("/del/{id}")
    public void deletePerson(@PathVariable long id){
        dynamoDbService.deletePerson(id);
    }

}
