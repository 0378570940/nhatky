package com.example.demo.models.in;

public class UserIn extends DiaryIn{
    private Long userId ;
    private String admin ;
    private String password ;
    private String token ;

    public UserIn() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public UserIn(Long userId, String admin, String password, String token) {
        this.userId = userId;
        this.admin = admin;
        this.password = password;
        this.token = token;
    }
}
