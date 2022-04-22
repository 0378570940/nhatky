package com.example.demo.models.dto;

public class UserDto extends DiaryDto{
    private long userId;
    private String username;
    private String admin ;
    private String password ;
    private String token ;

    public UserDto() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto(long userId, String username, String admin, String password, String token) {
        this.userId = userId;
        this.username = username;
        this.admin = admin;
        this.password = password;
        this.token = token;
    }
}
