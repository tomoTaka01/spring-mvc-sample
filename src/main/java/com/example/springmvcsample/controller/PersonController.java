package com.example.springmvcsample.controller;

import com.example.springmvcsample.domain.PersonForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @ModelAttribute
    public PersonForm setUp() {
        PersonForm personForm = new PersonForm();
        // set init value
        personForm.setFirstName("first Name1");
        personForm.setLastName("last name1");
        return personForm;
    }

    @RequestMapping("/")
    public String home() {
        logger.info("home");
        return "/person";
    }

    @PostMapping("/valid")
    public String valid(@Validated PersonForm personForm, BindingResult bindingResult) {
        logger.info("person valid");
        bindingResult.getAllErrors().forEach(e -> logger.error("error=[{}]", e.getDefaultMessage()));

        return "person";
    }
}
