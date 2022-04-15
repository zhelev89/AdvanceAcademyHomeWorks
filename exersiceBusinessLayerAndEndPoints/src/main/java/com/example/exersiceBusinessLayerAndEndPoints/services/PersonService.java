package com.example.exersiceBusinessLayerAndEndPoints.services;

import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Person;
import com.example.exersiceBusinessLayerAndEndPoints.exceptions.DuplicateRecordException;
import com.example.exersiceBusinessLayerAndEndPoints.exceptions.NotFoundRecordException;
import com.example.exersiceBusinessLayerAndEndPoints.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person save(Person person) {
        try {
            return personRepository.save(person);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(String.format("Person with ucn: %s, already exist", person.getUcn()));
        }
    }

    public Set<Person> findAll() {
        return new HashSet<>(personRepository.findAll());
    }

    public Person find(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundRecordException(String.format("Person with id: %s, not found", id)));
    }

    public Person find(String fullName) {
        return personRepository.findByFullName(fullName).orElseThrow(() -> new NotFoundRecordException(String.format("Person with fullName: %s, not found", fullName)));
    }

    public Person update(Person updatedPerson, Long id) {
        Person person = find(id);
        if (updatedPerson.getFullName() == null) {
            updatedPerson.setFullName(person.getFullName());
        }
        if (updatedPerson.getAge() == 0) {
            updatedPerson.setAge(person.getAge());
        }
        if (updatedPerson.getUcn() == null) {
            updatedPerson.setUcn(person.getUcn());
        }
        if (updatedPerson.getCar() == null) {
            updatedPerson.setCar(person.getCar());
        }

        person.setFullName(updatedPerson.getFullName());
        person.setCar(updatedPerson.getCar());
        person.setUcn(updatedPerson.getUcn());
        person.setAge(updatedPerson.getAge());
        return personRepository.save(person);
    }
}
