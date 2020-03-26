package com.project.ita5.answer;

import com.project.ita5.person.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnswerService {
    List<Answer> findAll();

    Answer find(String id);

    ResponseEntity saveAll(AnswerPerson answers);

    ResponseEntity<List<AnswerPerson>> findAllWithPerson();

    ResponseEntity updatePerson(Person person);
}
