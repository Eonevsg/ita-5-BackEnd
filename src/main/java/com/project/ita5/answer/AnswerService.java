package com.project.ita5.answer;

import com.project.ita5.person.Person;
import javafx.util.Pair;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> findAll();
    Optional<Answer> find(String id);
    List<Answer> saveAll(AnswerPerson answers);
    List<Pair<Person, List<Answer>>> findAllWithPerson();
}