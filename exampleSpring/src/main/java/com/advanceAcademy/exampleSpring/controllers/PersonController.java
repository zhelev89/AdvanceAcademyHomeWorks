package com.advanceAcademy.exampleSpring.controllers;

import com.advanceAcademy.exampleSpring.models.Person;
import com.advanceAcademy.exampleSpring.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonServices personServices;

    @Autowired
    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping(value = "/person/save")
    public String save(@RequestBody Person person) {
        personServices.save(person);
        return "Person successfully save";
    }

    @GetMapping(value = "/person/find/{id}")
    public Person findById(@PathVariable Long id) {
        return personServices.findById(id);
    }
}
