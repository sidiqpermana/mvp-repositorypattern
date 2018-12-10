package com.educa62.respositorypattern.data.jobs.usersjobs;

import java.util.List;

import com.educa62.respositorypattern.data.local.UsersLocalDataSource;
import com.educa62.respositorypattern.data.remote.UsersRemoteDataSource;
import com.educa62.respositorypattern.model.Users;

public class UsersRepository implements UsersDataSource {
    private UsersRemoteDataSource remoteDataSource;
    private UsersLocalDataSource lokalDataSource;

    public UsersRepository(UsersRemoteDataSource remoteDataSource, UsersLocalDataSource lokalDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.lokalDataSource = lokalDataSource;
    }

    @Override
    public void getListUsers(final getListUsersCallback callBack) {
        remoteDataSource.getListUsers(new getListUsersCallback() {
            @Override
            public void onSuccess(List<Users> data) {
                callBack.onSuccess(data);
            }

            @Override
            public void onFailed(String errorMessage) {
                callBack.onFailed(errorMessage);

            }
        });
    }

    @Override
    public void getDetailUser(int id_user, final getDetailUsersCallback callBack) {
        remoteDataSource.getDetailUser(id_user, new getDetailUsersCallback() {
                    @Override
                    public void onSuccess(Users data) {
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onFailed(String errorMesage) {
                        callBack.onFailed(errorMesage);
                    }
                }
        );

    }
}
