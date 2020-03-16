package com.project.ita5.question;

import com.project.ita5.answer.Answer;
import com.project.ita5.answer.AnswerRepository;
import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/question")
public class QuestionController {

    QuestionRepository questionRepository;
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public QuestionController(QuestionRepository questionRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.questionRepository = questionRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @GetMapping()
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
    @GetMapping(value="/{id}")
    public Optional<Question> getQuestion(@PathVariable("id") String id) {
        return questionRepository.findById(id);
    }

    @PostMapping()
    public Question postQuestion(@RequestBody Question question) {
        question.setId(sequenceGeneratorService.generateSequence(Question.SEQUENCE_NAME));
        questionRepository.save(question);
        return question;
    }
}
