package com.delirium.boiler.answer.service;

import com.delirium.boiler.answer.domain.Answer;
import com.delirium.boiler.exceptions.QuestionNotFoundException;

/**
 * Created by style on 29/04/2016.
 */
public interface AnswerService {

    /**
     * Create an answer for a question
     *
     * @param questionId question id to create answer for
     * @param authorName author name
     * @param body       answer body
     * @return The created answer entity
     */
    Answer createAnswer(Long questionId, String authorName, String body) throws QuestionNotFoundException;

}
