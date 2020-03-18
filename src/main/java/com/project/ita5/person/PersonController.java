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

    private PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> fetchPersons() {
        return personService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Person> fetchPerson(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person createPerson(@Valid @RequestBody Person person) {
        return personService.save(person);
    }

}
