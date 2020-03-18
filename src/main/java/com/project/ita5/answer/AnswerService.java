package com.project.ita5.answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAll();
    Answer find(String id);
    AnswerPerson saveAll(AnswerPerson answers);
    List<AnswerPerson> findAllWithPerson();
}
