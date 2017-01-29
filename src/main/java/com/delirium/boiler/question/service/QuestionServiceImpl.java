package com.delirium.boiler.question.service;

import com.delirium.boiler.question.domain.Question;
import com.delirium.boiler.question.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by style on 29/04/2016.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private static final int NUMBER_OF_QUESTIONS_TO_FETCH = 10;
    @Autowired
    QuestionRepository questionRepository;


    @Override
    public List<Question> getLatestQuestions(int limit) {
        PageRequest pageRequest = new PageRequest(0, limit);
        Page<Question> results = questionRepository.findAllOrderByCreatedTimeDesc(pageRequest);
        return results.getContent();
    }

    @Override
    public List<Question> getLatestQuestions() {
        return getLatestQuestions(NUMBER_OF_QUESTIONS_TO_FETCH);
    }

    @Override
    public Question createQuestion(String authorName, String title, String body) {
        Question question = new Question(authorName, title, body);
        questionRepository.save(question);
        questionRepository.flush();
        return question;
    }

    @Override
    public Question findOne(Long id) {
        Question question = questionRepository.findOne(id);
        return question;
    }
}
