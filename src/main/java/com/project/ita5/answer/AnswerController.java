package com.project.ita5.answer;

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

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    PersonRepository personRepository;

    @GetMapping()
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Answer> getAnswer(@PathVariable("id") String id) {
        return answerRepository.findById(id);
    }

    @PostMapping()
    public List<Answer> postAnswers(@RequestBody List<Answer> answers, @RequestBody Person person) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(person.getEmail()));
        if (personRepository.find(query).getId() == null) {
            personRepository.save(person);
            answerRepository.saveAll(answers);
        }

        return answers;
    }
}
