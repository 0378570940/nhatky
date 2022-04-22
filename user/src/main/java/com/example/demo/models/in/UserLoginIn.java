package com.example.demo.models.in;

import com.example.demo.models.out.UserUpdateOut;

public class UserLoginIn {
    private long id;
    private String userName;
    private String userPassWord;

    public void setId(long id) {
        this.id = id;
    }

    public UserLoginIn() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public UserUpdateOut setUserName() {
        return null;
    }

    public long getId() {
        return 0;
    }
}
