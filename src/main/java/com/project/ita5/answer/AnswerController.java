package com.project.ita5.answer;


import com.project.ita5.person.Person;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/answer")
public class AnswerController {

    private AnswerServiceImpl answerService;

    @Autowired
    public AnswerController(AnswerServiceImpl answerService) {
        this.answerService = answerService;
    }


    @GetMapping(value = "/all")
    public List<Answer> fetchAnswers() {
        return answerService.findAll();
    }

    @GetMapping()
    public List<Pair<Person, List<Answer>>> fetchAnswersWithPerson() {
        return answerService.findAllWithPerson();
    }

    @GetMapping(value = "/{id}")
    public Optional<Answer> fetchAnswer(@PathVariable("id") String id) {
        return answerService.find(id);
    }

    @PostMapping()
    public List<Answer> saveAnswers(@RequestBody List<Answer> answers) {
        return answerService.saveAll(answers);
    }
}
