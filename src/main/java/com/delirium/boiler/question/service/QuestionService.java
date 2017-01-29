package com.delirium.boiler.question.service;

import com.delirium.boiler.question.domain.Question;

import java.util.List;

/**
 * Created by style on 29/04/2016.
 */
public interface QuestionService {
    /**
     * get latest questions by creation time
     *
     * @param limit - max number of questions to fetch
     * @return a list of questions
     */
    List<Question> getLatestQuestions(int limit);

    /**
     * get 10 latest questions
     *
     * @return a list of 10 questions or less
     */
    List<Question> getLatestQuestions();

    /**
     * Create a question
     * @param authorName author name
     * @param title question title
     * @param body question body
     * @return The created question entity
     */
    Question createQuestion(String authorName, String title, String body);

    Question findOne(Long id);
}
