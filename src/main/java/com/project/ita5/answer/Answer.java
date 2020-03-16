package com.project.ita5.answer;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

public class Answer implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "answers_sequence";

    @Id
    private long id;
    private String question_id;
    private String answer;
    private String person_id;

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion_id() { return question_id; }

    public String getPerson_id() {
        return person_id;
    }

    public long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
}
