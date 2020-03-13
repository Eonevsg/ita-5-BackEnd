package com.project.ita5.answer;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnswerRepository extends MongoRepository<Answer, String> {
    public List<Answer> findAll();
}
