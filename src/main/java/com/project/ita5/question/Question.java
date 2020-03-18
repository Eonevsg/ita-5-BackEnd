package com.project.ita5.question;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Question {
    @Transient
    public static final String SEQUENCE_NAME = "questions_sequence";

    @Id
    private String id;
    private String fullQuestion;
    private String shortQuestion;


    public String getId() {
        return id;
    }

    public String getFullQuestion() {
        return fullQuestion;
    }

    public String getShortQuestion() {
        return shortQuestion;
    }
}
