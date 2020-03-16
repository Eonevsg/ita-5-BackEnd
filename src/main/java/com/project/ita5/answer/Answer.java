package com.project.ita5.answer;


import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Answer implements Serializable {
    @Id
    private String id;
    private String question_id;
    private String answer;
    private String person_id;

    public String getQuestion_id() {
        return question_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
}
