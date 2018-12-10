package com.educa62.respositorypattern;

import java.util.List;

import com.educa62.respositorypattern.model.Users;

public interface MyContract {

    interface View {
         void showProgress();
         void hideProgress();
         void showDataList(List<Users> data);
         void failureMessage(String msg);
    }

    interface Presenter {
        void getDataListUsers();
        void getDataDetailList();
    }
}
