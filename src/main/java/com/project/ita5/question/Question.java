package com.project.ita5.question;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Question {
    @Transient
    public static final String SEQUENCE_NAME = "questions_sequence";

    @Id
    private String id;
    private String fullQuestion;
    private String enFullQuestion;

    public Question(String id, String fullQuestion, String enFullQuestion) {
        this.id = id;
        this.fullQuestion = fullQuestion;
        this.enFullQuestion = enFullQuestion;
    }

    public String getId() {
        return id;
    }

    public String getFullQuestion() {
        return fullQuestion;
    }

    public String getEnFullQuestion() {
        return enFullQuestion;
    }
}
