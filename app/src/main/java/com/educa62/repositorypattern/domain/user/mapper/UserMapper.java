package com.educa62.repositorypattern.domain.user.mapper;

import com.educa62.repositorypattern.data.user.model.UserItem;
import com.educa62.repositorypattern.domain.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private static User getUser(UserItem userItem){
        return new User(userItem.name, userItem.email, userItem.username);
    }

    public static List<User> getUsers(List<UserItem> userItems){
        List<User> users = new ArrayList<>();
        for (UserItem userItem: userItems){
            users.add(getUser(userItem));
        }

        return users;
    }
}
