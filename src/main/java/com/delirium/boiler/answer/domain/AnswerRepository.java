package com.delirium.boiler.answer.domain;

import com.delirium.boiler.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Spring Data JPA repository for the Question entity.
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
