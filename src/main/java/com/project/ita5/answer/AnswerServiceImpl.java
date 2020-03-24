package com.project.ita5.answer;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import com.project.ita5.email_sender.EmailServiceImpl;
import com.project.ita5.person.ApplicationExtra;
import com.project.ita5.person.Person;
import com.project.ita5.person.PersonRepository;
import com.project.ita5.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<AnswerPerson> findAllWithPerson() {
        List<AnswerPerson> personAnswerList = new ArrayList<>();
        List<Person> personList = personRepository.findAll();
        for (Person person :
                personList) {
            List<Answer> answerList = answerRepository.findAllByPersonIdOrderByQuestionId(person.getId());
            personAnswerList.add(new AnswerPerson(person, answerList));
        }
        return personAnswerList;
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer find(String id) {
        return answerRepository.findById(id).orElse(null);
    }


    public AnswerPerson findPersonInfo(String id) {
       List<Person> personList = personRepository.findAll();
        for (Person person :
                personList) {
            if(person.getId().equals(id)){
                List<Answer> answerList = answerRepository.findAllByPersonIdOrderByQuestionId(person.getId());
                return new AnswerPerson(person, answerList);
            }
        }
        return null;
    }

    @Override
    public AnswerPerson saveAll(AnswerPerson answers) {
        Person currentPerson = personService.save(answers.person);
        if (currentPerson  != null) {
            String personId = currentPerson.getId();
            for (Answer answer :
                    answers.answerList) {
                answerRepository.save(new Answer(
                        Long.toString(generateSequence.generateSequence(Answer.SEQUENCE_NAME)),
                        answer.getQuestionId(),
                        answer.getAnswer(),
                        personId));
            }
            emailService.sendConfirmationEmail(currentPerson.getEmail());
            return new AnswerPerson(currentPerson, answerRepository.findAllByPersonIdOrderByQuestionId(personId));
        }
        return null;
    }

    @Override
    public AnswerPerson updatePerson(Person person) {
        personRepository.save(new Person(person.getId(), new ApplicationExtra(
                person.getExtra().getNotes(), person.getExtra().getApplicationValuation(), person.getExtra().getInterviewValuation(),
                person.getExtra().getStatus()
        )));
        return new AnswerPerson(personRepository.findById(person.getId()).orElse(null), answerRepository.findAllByPersonIdOrderByQuestionId(person.getId()));
    }
}
