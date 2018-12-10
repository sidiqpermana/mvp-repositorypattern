package com.educa62.repositorypattern;

import com.educa62.repositorypattern.data.UsersRepository;
import com.educa62.repositorypattern.data.local.UsersLocalDataSource;
import com.educa62.repositorypattern.data.remote.UsersRemoteDataSource;

public class Injection {

    public static UsersRepository provideRepository() {
        return new UsersRepository(new UsersRemoteDataSource(), new UsersLocalDataSource());
    }
}
