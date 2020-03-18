package com.project.ita5.answer;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import com.project.ita5.person.Person;
import com.project.ita5.person.PersonController;
import com.project.ita5.person.PersonRepository;
import com.project.ita5.question.Question;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/answer")
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
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
    public List<Answer> postAnswers(@RequestBody List<Answer> answers) {
        return answerService.saveAll(answers);
    }
}
