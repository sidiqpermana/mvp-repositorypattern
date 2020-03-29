package com.educa62.repositorypattern.data.remote;


import java.util.List;

import com.educa62.repositorypattern.data.UserRepository;
import com.educa62.repositorypattern.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRemoteRepositories implements UserRepository {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListUsers(final GetListUsersCallback callback) {
        Call<List<User>> call = apiInterface.getListUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callback.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onFailed(t.toString());
            }
        });


    }


    @Override
    public void getUserDetail(int userId, final GetUserDetailCallback callback) {

        Call<User> call = apiInterface.getDetailUsers(userId);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailed(t.toString());

            }
        });
    }


}
