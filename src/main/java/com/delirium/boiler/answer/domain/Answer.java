package com.delirium.boiler.answer.domain;

import com.delirium.boiler.question.domain.Question;
import com.delirium.boiler.tools.BoilerDateTimeDeserializer;
import com.delirium.boiler.tools.BoilerDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by style on 29/01/2017.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {


    @JsonSerialize(using = BoilerDateTimeSerializer.class)
    @JsonDeserialize(using = BoilerDateTimeDeserializer.class)
    @CreatedDate
    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "created_date", nullable = false)
    private DateTime createdTime = DateTime.now();

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String authorName;

    @Column
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Answer() {
        super();
    }

    public Answer(Question question, String authorName, String body) {
        this();
        this.question = question;
        this.authorName = authorName;
        this.body = body;
    }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    @JsonIgnore
    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @JsonIgnore
    public Question getQuestion() {
        return this.question;
    }

    @JsonProperty
    public Long getQuestionId() {
        return (this.question == null) ? null : this.question.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
