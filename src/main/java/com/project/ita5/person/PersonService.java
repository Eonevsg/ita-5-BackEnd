package com.project.ita5.person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Optional<Person> find(String id);
    Person save(Person person);
}
