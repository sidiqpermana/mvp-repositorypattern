package com.educa62.respositorypattern.data.jobs.usersjobs;

import java.util.List;

import com.educa62.respositorypattern.model.Users;

public interface UsersDataSource {

    void getListUsers(getListUsersCallback callBack);

    void getDetailUser(int id_user, getDetailUsersCallback callBack);

    interface getListUsersCallback {
        void onSuccess(List<Users> data);

        void onFailed(String errorMessage);
    }

    interface getDetailUsersCallback {
        void onSuccess(Users data);

        void onFailed(String errorMesage);
    }

}
