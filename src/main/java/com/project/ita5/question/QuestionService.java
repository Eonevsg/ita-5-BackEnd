package com.project.ita5.question;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();
    Optional<Question> find(String id);
    Question save(Question question);
}
