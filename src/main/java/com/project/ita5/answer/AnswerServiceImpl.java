package com.project.ita5.answer;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import com.project.ita5.email_sender.EmailServiceImpl;
import com.project.ita5.person.ApplicationExtra;
import com.project.ita5.person.Person;
import com.project.ita5.person.PersonRepository;
import com.project.ita5.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;
    private PersonRepository personRepository;
    private SequenceGeneratorService generateSequence;
    private PersonServiceImpl personService;
    private EmailServiceImpl emailService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, PersonRepository personRepository, SequenceGeneratorService generateSequence, PersonServiceImpl personService, EmailServiceImpl emailService) {
        this.answerRepository = answerRepository;
        this.personRepository = personRepository;
        this.generateSequence = generateSequence;
        this.personService = personService;
        this.emailService = emailService;
    }

    @Override
    public ResponseEntity<List<AnswerPerson>> findAllWithPerson() {
        List<AnswerPerson> personAnswerList = new ArrayList<>();
        List<Person> personList = personRepository.findAll();
        for (Person person : personList) {
            List<Answer> answerList = answerRepository.findAllByPersonIdOrderByQuestionId(person.getId());
            personAnswerList.add(new AnswerPerson(person, answerList));
        }
        return new ResponseEntity<List<AnswerPerson>>(personAnswerList, HttpStatus.OK);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer find(String id) {
        return answerRepository.findById(id).orElse(null);
    }


    public ResponseEntity<AnswerPerson> findPersonInfo(String id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            List<Answer> answerList = answerRepository.findAllByPersonIdOrderByQuestionId(person.getId());
            return new ResponseEntity<AnswerPerson>(new AnswerPerson(person, answerList), HttpStatus.OK);
        }
        return new ResponseEntity("No such person exists", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity saveAll(AnswerPerson answers) {
        ResponseEntity<Person> currentPerson = personService.save(answers.person);
        if (currentPerson.getStatusCode().isError()) {
            return currentPerson;
        }

        String personId = currentPerson.getBody().getId();
        for (Answer answer :
                answers.answerList) {
            answerRepository.save(new Answer(
                    Long.toString(generateSequence.generateSequence(Answer.SEQUENCE_NAME)),
                    answer.getQuestionId(),
                    answer.getAnswer(),
                    personId));
        }
        emailService.sendConfirmationEmail(currentPerson.getBody().getEmail());
        return new ResponseEntity(
                new AnswerPerson(currentPerson.getBody(), answerRepository.findAllByPersonIdOrderByQuestionId(personId)),
                HttpStatus.OK
        );

    }

    @Override
    public ResponseEntity updatePerson(Person person) {
        Person personToUpdate = personRepository.findById(person.getId()).orElse(null);

        Person personToReturn;
        ApplicationExtra applicationExtra;

        if ((person.getExtra().getStatus() == null)) {

            applicationExtra = createApplicationExtra(person, personToUpdate.getExtra().getDateTime(),
                    personToUpdate.getExtra().getStatus());
        } else {
            applicationExtra = createApplicationExtra(personToUpdate, personToUpdate.getExtra().getDateTime(),
                    person.getExtra().getStatus());
        }
        personToReturn = personRepository.save(new Person(personToUpdate, applicationExtra));
        return new ResponseEntity(new AnswerPerson(personToReturn,
                answerRepository.findAllByPersonIdOrderByQuestionId(person.getId())), HttpStatus.OK);
    }

    private ApplicationExtra createApplicationExtra(Person person, LocalDateTime date, String status) {
        return new ApplicationExtra(
                date,
                person.getExtra().getNotes(),
                person.getExtra().getApplicationValuation(),
                person.getExtra().getInterviewValuation(),
                person.getExtra().getTestValuation(),
                status);
    }
}
