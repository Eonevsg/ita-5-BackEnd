package com.project.ita5.person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(String id);

    Person save(Person person);
}
