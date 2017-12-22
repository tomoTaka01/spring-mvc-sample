package com.example.springmvcsample.controller;

import com.example.springmvcsample.domain.Person;
import com.sun.tools.internal.xjc.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @ModelAttribute
    public Person setUp(){
        Person person = new Person();
        // set init value
        person.setFirstName("first Name1");
        person.setLastName("last name1");
        return person;
    }

    @RequestMapping("/person")
    public String showPerson(){
        logger.info("show person");
        return "/person" ;
    }

    @PostMapping("/person/valid")
    public String valid(@Validated Person person, BindingResult bindingResult ){
        logger.info("valid");
        return "person";
    }
}
