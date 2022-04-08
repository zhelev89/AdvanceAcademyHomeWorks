package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.models.Person;
import com.advanceAcademy.exampleSpring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}
