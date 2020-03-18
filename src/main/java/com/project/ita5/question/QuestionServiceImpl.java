package com.project.ita5.question;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private SequenceGeneratorService generateSequence;
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(SequenceGeneratorService generateSequence, QuestionRepository questionRepository) {
        this.generateSequence = generateSequence;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(new Question(
                Long.toString(generateSequence.generateSequence(Question.SEQUENCE_NAME)),
                question.getFullQuestion(),
                question.getShortQuestion()
        ));
    }
}
