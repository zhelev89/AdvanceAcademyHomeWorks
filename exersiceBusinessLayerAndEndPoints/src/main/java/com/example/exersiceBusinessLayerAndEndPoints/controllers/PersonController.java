package com.example.exersiceBusinessLayerAndEndPoints.controllers;

import com.example.exersiceBusinessLayerAndEndPoints.converters.PersonConverter;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.PersonResponse;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.PersonSaveRequest;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Person;
import com.example.exersiceBusinessLayerAndEndPoints.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/persons")
public class PersonController {

    private PersonService personService;
    private PersonConverter personConverter;

    @PostMapping
    public ResponseEntity<PersonResponse> save(@RequestBody PersonSaveRequest personSaveRequest) {
        Person person = personConverter.convert(personSaveRequest);
        Person savedPerson = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personConverter.convert(savedPerson));
    }

    @GetMapping
    public ResponseEntity<Set<PersonResponse>> findAll() {
        Set<PersonResponse> persons = personService.findAll().stream()
                .map(person -> personConverter.convert(person))
                .collect(Collectors.toSet());
        return ResponseEntity.ok().body(persons);
    }
}
