package com.educa62.repositorypattern.users;

import java.util.List;

import com.educa62.repositorypattern.data.UserRepository;
import com.educa62.repositorypattern.data.UserDataSource;
import com.educa62.repositorypattern.model.User;

public class UsersPresenter implements UsersContract.Presenter {

    private UserRepository repository;
    private UsersContract.View view;

    public UsersPresenter(UserRepository repository, UsersContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListUsers() {
        view.showProgress();
        repository.getListUsers(new UserRepository.GetListUsersCallback() {
            @Override
            public void onSuccess(List<User> data) {
                view.hideProgress();
                view.showDataList(data);

            }

            @Override
            public void onFailed(String errorMessage) {
                view.hideProgress();
                view.showFailureMessage(errorMessage);
            }
        });
    }

}
