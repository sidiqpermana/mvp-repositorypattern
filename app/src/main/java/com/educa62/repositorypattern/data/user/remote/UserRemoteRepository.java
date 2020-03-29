package com.educa62.repositorypattern.data.user.remote;


import java.util.List;

import com.educa62.repositorypattern.data.user.UserRepository;
import com.educa62.repositorypattern.data.lib.ApiClient;
import com.educa62.repositorypattern.data.lib.ApiInterface;
import com.educa62.repositorypattern.data.user.model.UserItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteRepository implements UserRepository {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListUsers(final GetListUsersCallback callback) {
        Call<List<UserItem>> call = apiInterface.getListUsers();
        call.enqueue(new Callback<List<UserItem>>() {
            @Override
            public void onResponse(Call<List<UserItem>> call, Response<List<UserItem>> response) {
                callback.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<List<UserItem>> call, Throwable t) {
                callback.onFailed(t.toString());
            }
        });


    }


    @Override
    public void getUserDetail(int userId, final GetUserDetailCallback callback) {

        Call<UserItem> call = apiInterface.getDetailUsers(userId);
        call.enqueue(new Callback<UserItem>() {
            @Override
            public void onResponse(Call<UserItem> call, Response<UserItem> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<UserItem> call, Throwable t) {
                callback.onFailed(t.toString());

            }
        });
    }


}
