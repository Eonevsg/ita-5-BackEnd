package com.project.ita5.question;

import org.springframework.data.annotation.Id;

public class Question {
    @Id
    private String id;
    private String full_question;
    private String short_question;

    public String getId() {
        return id;
    }

    public String getFull_question() {
        return full_question;
    }

    public String getShort_question() {
        return short_question;
    }
}
