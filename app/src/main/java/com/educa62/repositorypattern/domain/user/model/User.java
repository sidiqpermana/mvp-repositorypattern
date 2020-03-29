package com.educa62.repositorypattern.domain.user.model;

public class User {
    private String name;

    private String email;

    private String username;

    public User(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
