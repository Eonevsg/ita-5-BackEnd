package com.project.ita5.answer;


import org.springframework.data.annotation.Id;

public class Answer {
    @Id
    private String id;
    private String questionId;
    private String answer;

    public Answer(String id, String questionId, String answer) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
    }
}
