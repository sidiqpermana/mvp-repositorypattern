package com.educa62.respositorypattern;

import com.educa62.respositorypattern.data.jobs.usersjobs.UsersRepository;
import com.educa62.respositorypattern.data.local.UsersLocalDataSource;
import com.educa62.respositorypattern.data.remote.UsersRemoteDataSource;

public class Injection {

    public static UsersRepository UsersInjection() {
        return new UsersRepository(new UsersRemoteDataSource(), new UsersLocalDataSource());
    }
}
