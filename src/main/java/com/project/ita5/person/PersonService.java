package com.project.ita5.person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Optional<Person> findById(String id);
    Person save(Person person);
}
