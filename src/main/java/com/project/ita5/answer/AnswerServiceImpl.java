package com.project.ita5.answer;

import com.project.ita5.database_sequence.SequenceGeneratorService;
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

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, PersonRepository personRepository, SequenceGeneratorService generateSequence, PersonServiceImpl personService) {
        this.answerRepository = answerRepository;
        this.personRepository = personRepository;
        this.generateSequence = generateSequence;
        this.personService = personService;
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
