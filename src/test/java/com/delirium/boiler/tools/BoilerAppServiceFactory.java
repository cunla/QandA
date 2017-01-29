package com.delirium.boiler.tools;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by style on 28/04/2016.
 */
public class BoilerAppServiceFactory {

    public static BoilerAppService createBoilerAppService() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        JavaNetCookieJar jncj = new JavaNetCookieJar(CookieHandler.getDefault());
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);
        httpClient.cookieJar(new RegularCookieJar());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8888/boiler/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
        BoilerAppService service = retrofit.create(BoilerAppService.class);
        return service;
    }
}
