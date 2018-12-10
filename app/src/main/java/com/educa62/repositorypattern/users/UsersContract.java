package com.educa62.repositorypattern.users;

import java.util.List;

import com.educa62.repositorypattern.model.User;

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
