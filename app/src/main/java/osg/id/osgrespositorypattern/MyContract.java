package osg.id.osgrespositorypattern;

import java.util.List;

import osg.id.osgrespositorypattern.model.Users;

public interface MyContract {

    interface view {
         void showProgress();
         void hideProgress();
         void showDataList(List<Users> data);
         void failureMessage(String msg);
    }

    interface presenter {
        void getDataListUsers();
        void getDataDetailList();
    }
}
