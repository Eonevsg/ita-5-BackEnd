package com.project.ita5.answer;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import com.project.ita5.person.Person;
import com.project.ita5.person.PersonController;
import com.project.ita5.person.PersonRepository;
import com.project.ita5.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/answer")
public class AnswerController {


    AnswerRepository answerRepository;
    SequenceGeneratorService sequenceGeneratorService;


    @Autowired
    public AnswerController(AnswerRepository answerRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.answerRepository = answerRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @CrossOrigin
    @GetMapping()
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional<Answer> getAnswer(@PathVariable("id") String id) {
        return answerRepository.findById(id);
    }

    @PostMapping()
    public List<Answer> postAnswers(@RequestBody List<Answer> answers) {
        for (Answer answer :
                answers) {
            answer.setId(Long.toString(sequenceGeneratorService.generateSequence(Answer.SEQUENCE_NAME)));
        }
        answerRepository.saveAll(answers);
        return answers;
    }

}
