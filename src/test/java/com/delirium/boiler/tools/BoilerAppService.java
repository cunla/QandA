package com.delirium.boiler.tools;

import com.delirium.boiler.answer.domain.Answer;
import com.delirium.boiler.question.domain.Question;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by style on 27/04/2016.
 */
public interface BoilerAppService {

    @POST("questions")
    Call<Question> createQuestion(@Body Question question);


    @POST("questions/{id}/answers")
    Call<Answer> createAnswer(@Path("id") Long id, @Body Answer answer);


    @GET("questions")
    Call<List<Question>> getLatestQuestions(@Query("limit") Integer limit);

    @GET("questions/{id}")
    Call<Question> getQuestionAnswers(@Path("id") Long id);


}
