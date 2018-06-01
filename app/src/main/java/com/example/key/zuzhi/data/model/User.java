package com.example.key.zuzhi.data.model;

import com.google.gson.annotations.SerializedName;

public class User {

    public String username;

    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
