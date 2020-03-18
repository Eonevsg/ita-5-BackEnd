package com.project.ita5.answer;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

public class Answer implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "answers_sequence";

    @Id
    private String id;
    private String questionId;
    private String answer;
    private String personId;

    public Answer(String id, String questionId, String answer, String personId) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.personId = personId;
    }

    public String getQuestionId() { return questionId; }

    public String getPersonId() {
        return personId;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
}
