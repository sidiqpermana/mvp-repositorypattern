package com.educa62.repositorypattern.presentation.users;

import com.educa62.repositorypattern.di.Injection;
import com.educa62.repositorypattern.domain.user.UserUseCase;
import com.educa62.repositorypattern.domain.user.model.User;

import java.util.List;

public class UsersPresenter implements UsersContract.Presenter {

    private UserUseCase userUseCase;
    private UsersContract.View view;

    public UsersPresenter(UsersContract.View view) {
        this.userUseCase = Injection.provideUserUseCase();
        this.view = view;
    }

    @Override
    public void getDataListUsers() {
        view.showProgress();
        userUseCase.getUserList(new UserUseCase.GetUsersCallback() {
            @Override
            public void onGetUsersComplete(List<User> users) {
                view.hideProgress();
                view.showDataList(users);
            }

            @Override
            public void onGetUsersError(String message) {
                view.hideProgress();
                view.showFailureMessage(message);
            }
        });
    }

}
