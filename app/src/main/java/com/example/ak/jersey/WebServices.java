package com.example.ak.jersey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ak on 2017. 03. 16..
 */
interface WebServices {
    String baseUrl = "https://10.0.2.2:8443/iszn/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(ConnectionFactory.getHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    WebServices webServices = retrofit.create(WebServices.class);



    @GET("rest/secured/users/get")
    Call<List<User>> users();

    @POST("rest/login?")
    Call<Void> postUsers(@Query("iszn_user") String email, @Query("iszn_password") String pass);



}
