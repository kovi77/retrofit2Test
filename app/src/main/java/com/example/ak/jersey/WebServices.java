package com.example.ak.jersey;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ak on 2017. 03. 16..
 */
interface WebServices {
    String baseUrl = "http://10.0.2.2:8080/iszn/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    WebServices webServices = retrofit.create(WebServices.class);

    @GET("rest/users/get")
    Call<List<User>> users();

    @POST("rest/users/send")
    Call<LoginResult> postUsers(@Body User u);


}
