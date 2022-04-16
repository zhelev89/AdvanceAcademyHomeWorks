package com.example.exersiceBusinessLayerAndEndPoints.controllers;

import com.example.exersiceBusinessLayerAndEndPoints.converters.PersonConverter;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person.PersonResponse;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person.PersonSaveRequest;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person.PersonUpdateRequest;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Person;
import com.example.exersiceBusinessLayerAndEndPoints.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
        Person findPerson = personService.find(id);
        PersonResponse personResponse = personConverter.convert(findPerson);
        return ResponseEntity.ok(personResponse);
    }

    @GetMapping(value = "/ucn/{ucn}")
    public ResponseEntity<PersonResponse> findByUcn(@PathVariable String ucn) {
        Person findPerson = personService.findByUcn(ucn);
        PersonResponse personResponse = personConverter.convert(findPerson);
        return ResponseEntity.ok(personResponse);
    }

    @PutMapping
    public ResponseEntity<PersonResponse> update(@RequestBody @Valid PersonUpdateRequest personUpdateRequest) {
        Person person = personConverter.convert(personUpdateRequest);
        Person updatedPerson = personService.update(person, person.getId());
        PersonResponse personResponse = personConverter.convert(updatedPerson);
        return ResponseEntity.ok(personResponse);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/ucn/{ucn}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String ucn) {
        personService.delete(ucn);
        return ResponseEntity.ok().build();
    }
}