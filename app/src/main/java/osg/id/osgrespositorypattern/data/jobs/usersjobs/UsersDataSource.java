package osg.id.osgrespositorypattern.data.jobs.usersjobs;

import android.support.annotation.NonNull;

import java.util.List;

import osg.id.osgrespositorypattern.model.Users;

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
