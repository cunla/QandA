package com.delirium.boiler.question.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Spring Data JPA repository for the Question entity.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("select q from Question q order by q.createdTime desc")
    Page<Question> findAllOrderByCreatedTimeDesc(Pageable pageable);

}
