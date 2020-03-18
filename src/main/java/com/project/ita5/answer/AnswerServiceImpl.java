package com.project.ita5.answer;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import com.project.ita5.person.Person;
import com.project.ita5.person.PersonRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;
    private PersonRepository personRepository;
    private SequenceGeneratorService generateSequence;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, PersonRepository personRepository, SequenceGeneratorService generateSequence) {
        this.answerRepository = answerRepository;
        this.personRepository = personRepository;
        this.generateSequence = generateSequence;
    }

    @Override
    public List<Pair<Person, List<Answer>>> findAllWithPerson() {
        List<Pair<Person, List<Answer>>> personAnswerList = new ArrayList<>();
        List<Person> personList = personRepository.findAll();
        for (Person person :
                personList) {
            List<Answer> answerList = answerRepository.findAllByPersonIdOrderByQuestionId(person.getId());
            Pair<Person, List<Answer>> personAnswerPair = new Pair<>(person, answerList);
            personAnswerList.add(personAnswerPair);
        }
        return personAnswerList;
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> find(String id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> saveAll(List<Answer> answers) {
        String personId = null;
        for (Answer answer :
                answers) {
            answerRepository.save(new Answer(
                    Long.toString(generateSequence.generateSequence(Answer.SEQUENCE_NAME)),
                    answer.getQuestionId(),
                    answer.getAnswer(),
                    answer.getPersonId()));
            if (personId == null) {
                personId = answer.getPersonId();
            }
        }
        return answerRepository.findAllByPersonIdOrderByQuestionId(personId);
    }
}
