package com.project.ita5.question;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Question {
    @Transient
    public static final String SEQUENCE_NAME = "questions_sequence";

    @Id
    private long id;
    private String full_question;
    private String short_question;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFull_question() {
        return full_question;
    }

    public String getShort_question() {
        return short_question;
    }
}
