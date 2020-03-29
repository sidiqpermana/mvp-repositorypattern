package com.educa62.repositorypattern.data.user;

import java.util.List;

import com.educa62.repositorypattern.data.user.local.UserLocalRepository;
import com.educa62.repositorypattern.data.user.model.UserItem;
import com.educa62.repositorypattern.data.user.remote.UserRemoteRepository;

public class UserDataSource implements UserRepository {
    private UserRemoteRepository remoteDataSource;
    private UserLocalRepository localDataSource;

    public UserDataSource(UserRemoteRepository remoteDataSource, UserLocalRepository localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListUsers(final GetListUsersCallback callback) {
        remoteDataSource.getListUsers(new GetListUsersCallback() {
            @Override
            public void onSuccess(List<UserItem> data) {
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
                    public void onSuccess(UserItem data) {
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
