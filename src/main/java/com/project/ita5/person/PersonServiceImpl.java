package com.project.ita5.person;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private SequenceGeneratorService generateSequence;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, SequenceGeneratorService generateSequence) {
        this.personRepository = personRepository;
        this.generateSequence = generateSequence;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person save(Person person) {
        if (personRepository.findByEmail(person.getEmail()) == null) {
            return personRepository.save(new Person(
                    Long.toString(generateSequence.generateSequence(Person.SEQUENCE_NAME)),
                    person.getName(),
                    person.getSurname(),
                    person.getPhone(),
                    person.getEmail(),
                    person.getUni(),
                    new ApplicationExtra(LocalDateTime.now())
                    ));
        }
        return null;
    }
}
