package com.delirium.boiler.question.controller;

import com.delirium.boiler.question.domain.Question;
import com.delirium.boiler.question.domain.Views;
import com.delirium.boiler.question.service.QuestionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by style on 29/1/2017.
 */
@Controller
public class QuestionController {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    //    @PreAuthorize("hasAuthority('ADMIN')")
    @JsonView(Views.Summary.class)
    @RequestMapping(value = "/questions",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Question>> getLatestQuestions(
            @RequestParam(name = "limit", defaultValue = "10") Integer limit) {
        List<Question> questions = questionService.getLatestQuestions(limit);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "/questions/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Question> getQuestionAnswers(@PathVariable("id") Long id) {
        Question question = questionService.findOne(id);
        return (question != null) ?
                new ResponseEntity<>(question, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/questions",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        if (null == question) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Question res = questionService.createQuestion(question.getAuthorName(), question.getTitle(), question.getBody());
        return new ResponseEntity<Question>(res, HttpStatus.CREATED);
    }

}
