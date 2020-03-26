package com.project.ita5.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public Person fetchPerson(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @PostMapping
    public ResponseEntity createPerson(@Valid @RequestBody Person person) {
        return personService.save(person);
    }

}
