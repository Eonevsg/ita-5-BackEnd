package com.project.ita5.question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    Question findById(String id);

    Question save(Question question);
}
