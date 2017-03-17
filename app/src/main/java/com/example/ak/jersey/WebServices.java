package com.example.ak.jersey;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by ak on 2017. 03. 16..
 */
interface WebServices {
    String baseUrl = "http://10.0.2.2:8080/iszn/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    WebServices webServices = retrofit.create(WebServices.class);

    @GET("rest/users")
    Call<List<User>> users();


}
