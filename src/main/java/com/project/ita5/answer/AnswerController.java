package com.project.ita5.answer;

import com.project.ita5.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<AnswerPerson>> fetchAnswersWithPerson() {
        return answerService.findAllWithPerson();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnswerPerson> fetchAnswer(@PathVariable("id") String id) {
        return answerService.findPersonInfo(id);
    }

    @PostMapping()
    public ResponseEntity saveAnswers(@RequestBody @Valid AnswerPerson answerPerson) {
        return answerService.saveAll(answerPerson);
    }

    @PatchMapping
    public ResponseEntity updatePerson(@RequestBody Person person) {
        return answerService.updatePerson(person);
    }

}
