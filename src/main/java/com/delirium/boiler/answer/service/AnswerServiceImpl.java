package com.delirium.boiler.answer.service;

import com.delirium.boiler.answer.domain.Answer;
import com.delirium.boiler.answer.domain.AnswerRepository;
import com.delirium.boiler.exceptions.QuestionNotFoundException;
import com.delirium.boiler.question.domain.Question;
import com.delirium.boiler.question.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by style on 29/04/2016.
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Long questionId, String authorName, String body) throws QuestionNotFoundException {
        Question question = questionRepository.findOne(questionId);
        if (question == null) {
            throw new QuestionNotFoundException(questionId);
        }
        Answer answer = new Answer(question, authorName, body);
        answerRepository.save(answer);
        return answer;
    }
}
