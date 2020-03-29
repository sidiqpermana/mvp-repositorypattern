package com.educa62.repositorypattern;

import com.educa62.repositorypattern.data.UserDataSource;
import com.educa62.repositorypattern.data.UserRepository;
import com.educa62.repositorypattern.data.local.UserLocalRepository;
import com.educa62.repositorypattern.data.remote.UserRemoteRepository;

public class Injection {

    public static UserRepository provideRepository() {
        return new UserDataSource(new UserRemoteRepository(), new UserLocalRepository());
    }
}
