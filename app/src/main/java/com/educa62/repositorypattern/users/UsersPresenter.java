package com.educa62.repositorypattern.users;

import java.util.List;

import com.educa62.repositorypattern.data.UsersDataSource;
import com.educa62.repositorypattern.data.UsersRepository;
import com.educa62.repositorypattern.model.User;

public class UsersPresenter implements UsersContract.Presenter {

    private UsersRepository repository;
    private UsersContract.View view;

    public UsersPresenter(UsersRepository repository, UsersContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListUsers() {
        view.showProgress();
        repository.getListUsers(new UsersDataSource.GetListUsersCallback() {
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
