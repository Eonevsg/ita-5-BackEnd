package com.project.ita5.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionController {

    private QuestionServiceImpl questionService;

    @Autowired
    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public List<Question> fetchuestions() {
        return questionService.findAll();
    }


    @GetMapping(value = "/{id}")
    public Question fetchQuestion(@PathVariable("id") String id) {
        return questionService.findById(id);
    }

    @PostMapping()
    public Question createQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }
}
