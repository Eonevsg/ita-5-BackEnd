package com.project.ita5.person;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(String id);

    ResponseEntity save(Person person);
}
