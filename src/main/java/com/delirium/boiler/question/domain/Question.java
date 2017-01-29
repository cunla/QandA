package com.delirium.boiler.question.domain;

import com.delirium.boiler.answer.domain.Answer;
import com.delirium.boiler.tools.BoilerDateTimeDeserializer;
import com.delirium.boiler.tools.BoilerDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by style on 28/04/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @JsonIgnore
    private static final Logger log = LoggerFactory.getLogger(Question.class);

    @JsonView(Views.Summary.class)
    @JsonSerialize(using = BoilerDateTimeSerializer.class)
    @JsonDeserialize(using = BoilerDateTimeDeserializer.class)
    @CreatedDate
    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column( nullable = false)
    private DateTime createdTime = DateTime.now();

    @JsonView(Views.Summary.class)
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Summary.class)
    @Column
    private String authorName;

    @JsonView(Views.Summary.class)
    @Column
    private String title;

    @Column
    private String body;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Question() {
        super();
        this.answers = new LinkedList<>();
    }

    public Question(String authorName, String title, String body) {
        this();
        this.authorName = authorName;
        this.title = title;
        this.body = body;
    }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    @JsonView(Views.Summary.class)
    @JsonProperty
    public Integer numberOfAnswers() {
        return this.answers.size();
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty
    public List<Answer> getAnswers() {
        return answers;
    }

    @JsonIgnore
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
