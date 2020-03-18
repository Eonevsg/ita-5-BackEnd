package com.project.ita5.person;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/person")
public class PersonController {

    PersonRepository personRepository;
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public PersonController(PersonRepository personRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.personRepository = personRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }


    @GetMapping
    public List<Person> getPersons() {
        return personRepository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable("id") String id) {
        return personRepository.findById(id);
    }

    @PostMapping
    public String setPerson(@Valid @RequestBody Person person) {
        //person.setId(Long.toString(sequenceGeneratorService.generateSequence(Person.SEQUENCE_NAME)));
        personRepository.save(person);
        return person.getId();
    }

}
