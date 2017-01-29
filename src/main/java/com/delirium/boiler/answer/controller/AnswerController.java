package com.delirium.boiler.answer.controller;

import com.delirium.boiler.answer.domain.Answer;
import com.delirium.boiler.answer.domain.Views;
import com.delirium.boiler.answer.service.AnswerService;
import com.delirium.boiler.exceptions.QuestionNotFoundException;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by style on 29/01/2017.
 */
@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;


    @RequestMapping(value = "/questions/{id}/answers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Answer> createAnswer(@PathVariable("id") Long id, @RequestBody Answer answer) {
        if (null == answer) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Answer res = answerService.createAnswer(id, answer.getAuthorName(), answer.getBody());
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (QuestionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
