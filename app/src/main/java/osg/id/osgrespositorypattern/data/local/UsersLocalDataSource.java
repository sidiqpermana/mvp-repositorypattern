package osg.id.osgrespositorypattern.data.local;

import osg.id.osgrespositorypattern.data.jobs.usersjobs.UsersDataSource;

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
