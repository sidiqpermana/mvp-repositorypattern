package com.educa62.repositorypattern.data.user;

import java.util.List;

import com.educa62.repositorypattern.data.user.model.UserItem;

public interface UserRepository {

    void getListUsers(GetListUsersCallback callBack);

    void getUserDetail(int userId, GetUserDetailCallback callback);

    interface GetListUsersCallback {
        void onSuccess(List<UserItem> data);

        void onFailed(String errorMessage);
    }

    interface GetUserDetailCallback {
        void onSuccess(UserItem data);

        void onFailed(String errorMessage);
    }

}
