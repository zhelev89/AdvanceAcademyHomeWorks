package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.exceptions.NotFoundRecordException;
import com.advanceAcademy.exampleSpring.models.Person;
import com.advanceAcademy.exampleSpring.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServices {

    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Person findByUcn(String ucn) {
        return personRepository.findByUcn(ucn)
                .orElseThrow(() -> new NotFoundRecordException(String.format("Person with UCN:%s, not found", ucn)));
    }
}
