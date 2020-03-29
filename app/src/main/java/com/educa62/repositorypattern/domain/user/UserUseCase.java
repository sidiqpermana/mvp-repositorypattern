package com.educa62.repositorypattern.domain.user;

import com.educa62.repositorypattern.domain.user.model.User;

import java.util.List;

public interface UserUseCase {
    void getUserList(GetUsersCallback getUsersCallback);

    interface GetUsersCallback{
        void onGetUsersComplete(List<User> users);

        void onGetUsersError(String message);
    }
}
