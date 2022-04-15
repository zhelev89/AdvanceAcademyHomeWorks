package com.example.exersiceBusinessLayerAndEndPoints.converters;

import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person.PersonResponse;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person.PersonSaveRequest;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person.PersonUpdateRequest;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    public Person convert(PersonSaveRequest personSaveRequest) {
        return Person.builder()
                .fullName(personSaveRequest.getFullName())
                .age(personSaveRequest.getAge())
                .ucn(personSaveRequest.getUcn())
                .build();
    }

    public PersonResponse convert(Person person) {
        return PersonResponse.builder()
                .fullName(person.getFullName())
                .age(person.getAge())
                .ucn(person.getUcn())
                .build();
    }

    public Person convert (PersonUpdateRequest personUpdateRequest) {
        return Person.builder()
                .id(personUpdateRequest.getId())
                .fullName(personUpdateRequest.getFullName())
                .age(personUpdateRequest.getAge())
                .ucn(personUpdateRequest.getUcn())
                .build();
    }
}
