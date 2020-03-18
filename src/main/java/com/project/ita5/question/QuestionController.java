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

   private QuestionServiceImpl questionService;

   @Autowired
    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public List<Question> fetchuestions() {
        return questionService.findAll();
    }


    @GetMapping(value="/{id}")
    public Question fetchQuestion(@PathVariable("id") String id) {
        return questionService.findById(id);
    }

    @PostMapping()
    public Question createQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }
}
