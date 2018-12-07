package osg.id.osgrespositorypattern.data.remote;


import java.util.List;

import osg.id.osgrespositorypattern.data.jobs.usersjobs.UsersDataSource;
import osg.id.osgrespositorypattern.model.Users;
import osg.id.osgrespositorypattern.network.ApiClient;
import osg.id.osgrespositorypattern.network.ApiInterface;
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
