package com.educa62.respositorypattern.data.remote;


import java.util.List;

import com.educa62.respositorypattern.data.jobs.usersjobs.UsersDataSource;
import com.educa62.respositorypattern.model.Users;
import com.educa62.respositorypattern.network.ApiClient;
import com.educa62.respositorypattern.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRemoteDataSource implements UsersDataSource {

    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListUsers(final getListUsersCallback callBack) {
        Call<List<Users>> call = apiInterface.getListUsers();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                callBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                callBack.onFailed(t.toString());
            }
        });


    }


    @Override
    public void getDetailUser(int id_user, final getDetailUsersCallback callback) {

        Call<Users> call = apiInterface.getDetailUsers(id_user);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                callback.onFailed(t.toString());

            }
        });
    }


}
