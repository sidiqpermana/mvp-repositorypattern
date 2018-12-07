package osg.id.osgrespositorypattern;

import osg.id.osgrespositorypattern.data.jobs.usersjobs.UsersRepository;
import osg.id.osgrespositorypattern.data.local.UsersLocalDataSource;
import osg.id.osgrespositorypattern.data.remote.UsersRemoteDataSource;

public class Injection {

    public static UsersRepository UsersInjection() {
        return new UsersRepository(new UsersRemoteDataSource(), new UsersLocalDataSource());
    }
}
