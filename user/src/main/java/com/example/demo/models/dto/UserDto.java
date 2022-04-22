package com.example.demo.models.dto;

import javax.persistence.Column;

public class UserDto {
    private long id;
    private String userName;
    private Integer userAge;
    private String userFullname;
    private String userPassword;
    private String userEmail;

    public UserDto(String userName, String userFullname, String userEmail, String userPassword, long id, Integer userAge) {
        this.id = this.id;
        this.userName = this.userName;
        this.userAge = this.userAge;
        this.userFullname = this.userFullname;
        this.userPassword = this.userPassword;
        this.userEmail = this.userEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
