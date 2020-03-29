package com.educa62.repositorypattern.data.user.local;

import com.educa62.repositorypattern.data.user.UserRepository;

public class UserLocalRepository implements UserRepository {


    @Override
    public void getListUsers(GetListUsersCallback callBack) {
        //get data from SQlite database

    }

    @Override
    public void getUserDetail(int userId, GetUserDetailCallback callback) {
        // get detail user
    }
}
