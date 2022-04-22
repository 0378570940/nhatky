package com.example.demo.controller;

import com.example.demo.models.in.UserIn;
import com.example.demo.service.LoginService;
import com.example.demo.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private LogoutService logoutService;

    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody UserIn userIn){
        return loginService.loginUser(userIn);
    }

    @GetMapping("logout")
    private ResponseEntity<?> logoutUser(@RequestHeader(name = "Auth") String token){
        return logoutService.logoutUser(token);
    }
}
