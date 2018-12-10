package com.educa62.repositorypattern.data;

import java.util.List;

import com.educa62.repositorypattern.model.User;

public interface UsersDataSource {

    void getListUsers(GetListUsersCallback callBack);

    void getUserDetail(int userId, GetUserDetailCallback callback);

    interface GetListUsersCallback {
        void onSuccess(List<User> data);

        void onFailed(String errorMessage);
    }

    interface GetUserDetailCallback {
        void onSuccess(User data);

        void onFailed(String errorMessage);
    }

}
