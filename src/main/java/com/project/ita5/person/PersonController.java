package com.project.ita5.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathParam("id") String id) {
        return personRepository.findById(id);
    }

    public boolean setPerson(Person person) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(person.getEmail()));
        if (personRepository.find(query).getId() == null) {
            personRepository.save(person);
            return true;
        }
        return false;

    }

}
