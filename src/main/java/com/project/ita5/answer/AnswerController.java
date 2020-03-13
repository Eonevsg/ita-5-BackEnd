package com.project.ita5.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AnswerController {

    @Autowired
    AnswerRepository repo;

    @GetMapping(value="api/answer")
    public String getAnswers() {
        List<Answer> asd = repo.findAll();
        return asd.toString();
    }

    @PostMapping(value="/")
    public String postAnswers() {
        return "test";
    }
}
