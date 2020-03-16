package com.project.ita5.question;

import com.project.ita5.answer.Answer;
import com.project.ita5.answer.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/question")
public class QuestionController {

    QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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
        questionRepository.save(question);
        return question;
    }
}
