package com.foodapp.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private UserType role;

    public User(int id, String name, String email, String password, UserType role, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getRole() {
        return role;
    }
}
