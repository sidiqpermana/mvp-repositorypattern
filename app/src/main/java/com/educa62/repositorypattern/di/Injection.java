package com.educa62.repositorypattern.di;

import com.educa62.repositorypattern.data.user.UserDataSource;
import com.educa62.repositorypattern.data.user.UserRepository;
import com.educa62.repositorypattern.data.user.local.UserLocalRepository;
import com.educa62.repositorypattern.data.user.remote.UserRemoteRepository;
import com.educa62.repositorypattern.domain.user.UserInteractor;
import com.educa62.repositorypattern.domain.user.UserUseCase;

public class Injection {

    private static UserRepository provideRepository() {
        return new UserDataSource(new UserRemoteRepository(), new UserLocalRepository());
    }

    public static UserUseCase provideUserUseCase(){
        return new UserInteractor(provideRepository());
    }
}
