package com.project.ita5.answer;

import com.project.ita5.person.Person;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;

public class AnswerPerson {
    Person person;
    List<Answer> answerList;


    public Person getPerson() {
        return person;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
}
