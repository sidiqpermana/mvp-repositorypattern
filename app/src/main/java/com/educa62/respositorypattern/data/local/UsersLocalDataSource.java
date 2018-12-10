package com.educa62.respositorypattern.data.local;

import com.educa62.respositorypattern.data.jobs.usersjobs.UsersDataSource;

public class UsersLocalDataSource implements UsersDataSource {


    @Override
    public void getListUsers(getListUsersCallback callBack) {
        //get data from SQlite database

    }

    @Override
    public void getDetailUser(int id_user, getDetailUsersCallback callBack) {
        // get detail user
    }
}
