package com.project.ita5.answer;


import com.project.ita5.person.Person;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Answer fetchAnswer(@PathVariable("id") String id) {
        return answerService.find(id);
    }

    @PostMapping()
    public AnswerPerson saveAnswers(@RequestBody @Valid AnswerPerson answerPerson) {
        return answerService.saveAll(answerPerson);
    }
    @PostMapping(value = "/test")
    public Answer save(@Valid @RequestBody Answer answer) {
        //return answerService.save(answer);
        return answer;
    }

}
