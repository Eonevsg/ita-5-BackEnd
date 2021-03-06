package com.project.ita5.answer;

import com.project.ita5.person.Person;

import javax.validation.Valid;
import java.util.List;

public class AnswerPerson {
    @Valid
    Person person;
    @Valid
    List<Answer> answerList;

    public AnswerPerson(Person person, List<Answer> answerList) {
        this.person = person;
        this.answerList = answerList;
    }

    public Person getPerson() {
        return person;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
}
