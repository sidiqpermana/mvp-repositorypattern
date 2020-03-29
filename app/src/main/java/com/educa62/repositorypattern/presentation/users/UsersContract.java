package com.educa62.repositorypattern.presentation.users;

import com.educa62.repositorypattern.domain.user.model.User;

import java.util.List;

public interface UsersContract {

    interface View {
         void showProgress();
         void hideProgress();
         void showDataList(List<User> data);
         void showFailureMessage(String msg);
    }

    interface Presenter {
        void getDataListUsers();
    }
}
