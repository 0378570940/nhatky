package com.example.demo.models.dto;

public class LoginDto {
    private String admin ;
    private String password ;
    private String token ;

    public LoginDto() {
    }

    public LoginDto( String admin, String password, String token) {
        this.admin = admin;
        this.password = password;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
