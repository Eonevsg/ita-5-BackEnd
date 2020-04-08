package com.project.ita5.person;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity save(Person person) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        if (personRepository.findByEmail(person.getEmail()) != null) {
            return new ResponseEntity(
                    "{\"ltErrorMessage\":" + "\"Registracijos forma jau yra pateikta su šiuo el. pašto adresu.\","
                    +"\"enErrorMessage\":" + "\"Application with this email already exists.\"}",
                    responseHeaders,
                    HttpStatus.BAD_REQUEST
            );
        }
        if (personRepository.findByPhone(person.getPhone()) != null) {
            return new ResponseEntity(
                    "{\"ltErrorMessage\":" + "\"Registracijos forma jau yra pateikta su šiuo tel. numeriu.\","
                            +"\"enErrorMessage\":" + "\"Application with this phone number already exists.\"}",
                    responseHeaders,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(personRepository.save(new Person(
                    Long.toString(generateSequence.generateSequence(Person.SEQUENCE_NAME)),
                    person.getName(),
                    person.getSurname(),
                    person.getPhone(),
                    person.getEmail(),
                    person.getUni(),
                    person.getContract(),
                    new ApplicationExtra(LocalDateTime.now(), "Nauja")
            )), HttpStatus.OK);
    }
}
