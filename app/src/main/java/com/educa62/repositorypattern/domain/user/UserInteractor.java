package com.educa62.repositorypattern.domain.user;

import com.educa62.repositorypattern.data.user.UserRepository;
import com.educa62.repositorypattern.data.user.model.UserItem;
import com.educa62.repositorypattern.domain.user.mapper.UserMapper;

import java.util.List;

public class UserInteractor implements UserUseCase {

    private UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getUserList(final GetUsersCallback getUsersCallback) {
        userRepository.getListUsers(new UserRepository.GetListUsersCallback() {
            @Override
            public void onSuccess(List<UserItem> data) {
                getUsersCallback.onGetUsersComplete(UserMapper.getUsers(data));
            }

            @Override
            public void onFailed(String errorMessage) {
                getUsersCallback.onGetUsersError(errorMessage);
            }
        });
    }
}
