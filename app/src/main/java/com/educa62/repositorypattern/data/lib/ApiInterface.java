package com.educa62.repositorypattern.data.lib;


import java.util.List;

import com.educa62.repositorypattern.data.user.model.UserItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/users")
    Call<List<UserItem>> getListUsers();

    @GET("/post/{id}")
    Call<UserItem> getDetailUsers(@Path("id") int id);
}



