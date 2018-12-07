package osg.id.osgrespositorypattern;

import java.util.List;

import osg.id.osgrespositorypattern.data.jobs.usersjobs.UsersDataSource;
import osg.id.osgrespositorypattern.data.jobs.usersjobs.UsersRepository;
import osg.id.osgrespositorypattern.model.Users;

public class MyPresenter implements MyContract.presenter {

    private UsersRepository repository;
    private MyContract.view view;

    public MyPresenter(UsersRepository repository, MyContract.view view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListUsers() {
        view.showProgress();
        repository.getListUsers(new UsersDataSource.getListUsersCallback() {
            @Override
            public void onSuccess(List<Users> data) {
                view.hideProgress();
                view.showDataList(data);

            }

            @Override
            public void onFailed(String errorMessage) {
                view.hideProgress();
                view.failureMessage(errorMessage);
            }
        });
    }

    @Override
    public void getDataDetailList() {

    }
}
