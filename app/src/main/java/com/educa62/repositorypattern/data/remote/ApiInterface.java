package com.educa62.repositorypattern.data.remote;


import java.util.List;

import com.educa62.repositorypattern.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/users")
    Call<List<User>> getListUsers();

    @GET("/post/{id}")
    Call<User> getDetailUsers(@Path("id") int id);
}



