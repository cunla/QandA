package com.delirium.boiler;

import com.delirium.boiler.answer.domain.Answer;
import com.delirium.boiler.question.domain.Question;
import com.delirium.boiler.tools.BoilerAppService;
import com.delirium.boiler.tools.BoilerAppServiceFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by style on 29/01/2017.
 */
public class TestQuestion {
    private BoilerAppService service = BoilerAppServiceFactory.createBoilerAppService();

    @Test
    public void testCreateQuestion() throws IOException {
        Question q1 = new Question("daniel", "title", "body");
        Question q1res = service.createQuestion(q1).execute().body();
        assertEquals(q1.getAuthorName(), q1res.getAuthorName());
        assertEquals(q1.getTitle(), q1res.getTitle());
        assertEquals(q1.getBody(), q1res.getBody());
        assertEquals(new Integer(0), q1res.numberOfAnswers());
    }

    @Test
    public void testCreateAndGetAnswers() throws IOException {
        Question q1 = new Question("daniel", "title", "body");
        Question q1res = service.createQuestion(q1).execute().body();
        assertEquals(q1.getAuthorName(), q1res.getAuthorName());
        assertEquals(q1.getTitle(), q1res.getTitle());
        assertEquals(q1.getBody(), q1res.getBody());
        assertEquals(new Integer(0), q1res.numberOfAnswers());
        Long id = q1res.getId();

        q1res = service.getQuestionAnswers(id).execute().body();
        assertEquals(q1.getAuthorName(), q1res.getAuthorName());
        assertEquals(q1.getTitle(), q1res.getTitle());
        assertEquals(q1.getBody(), q1res.getBody());
        assertEquals(new Integer(0), q1res.numberOfAnswers());

        Answer answer = new Answer(null, "AnswerAuthor", "answer-body");
        Answer answerRes = service.createAnswer(id, answer).execute().body();
        assertEquals(answer.getBody(), answerRes.getBody());
        assertEquals(answer.getAuthorName(), answerRes.getAuthorName());

        q1res = service.getQuestionAnswers(id).execute().body();
        assertEquals(1, q1res.getAnswers().size());
    }

}
