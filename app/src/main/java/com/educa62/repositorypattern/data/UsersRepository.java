package com.educa62.repositorypattern.data;

import java.util.List;

import com.educa62.repositorypattern.data.local.UsersLocalDataSource;
import com.educa62.repositorypattern.data.remote.UsersRemoteDataSource;
import com.educa62.repositorypattern.model.User;

public class UsersRepository implements UsersDataSource {
    private UsersRemoteDataSource remoteDataSource;
    private UsersLocalDataSource localDataSource;

    public UsersRepository(UsersRemoteDataSource remoteDataSource, UsersLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListUsers(final GetListUsersCallback callback) {
        remoteDataSource.getListUsers(new GetListUsersCallback() {
            @Override
            public void onSuccess(List<User> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onFailed(String errorMessage) {
                callback.onFailed(errorMessage);

            }
        });
    }

    @Override
    public void getUserDetail(int userId, final GetUserDetailCallback callback) {
        remoteDataSource.getUserDetail(userId, new GetUserDetailCallback() {
                    @Override
                    public void onSuccess(User data) {
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onFailed(String errorMessage) {
                        callback.onFailed(errorMessage);
                    }
                }
        );
    }
}
