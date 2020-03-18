package com.project.ita5.person;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import com.project.ita5.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Optional<Person> findById(String id) {
        return personRepository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(new Person(Long.toString(generateSequence.generateSequence(User.SEQUENCE_NAME)),
                person.getName(),
                person.getSurname(),
                person.getPhone(),
                person.getEmail(),
                person.getUni()));
    }
}
