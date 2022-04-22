package com.example.demo.controller;

import com.example.demo.entities.UserEntity;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.in.UserIn;
import com.example.demo.models.in.UserLoginIn;
import com.example.demo.models.out.UserUpdateOut;
import com.example.demo.services.DeleteServices;
import com.example.demo.services.ResultService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //thêm vào db post
    @PostMapping("/user")
    public ResultService create(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

    //lấy dưa liệu db get
//    @GetMapping("/user")
//    public ResultService findall(){
//        return (ResultService) userService.findAll();
//    }
    //lấy toàn bộ dưa liệu db get
    @GetMapping("/user")
    public List<UserDto> findAll() {
        return userService.findAll();
    }


    //lấy id trong db get
    @GetMapping("/user/{id}")
    public ResultService findById(@PathVariable long id) {
        return userService.findById(id);
    }

    //sửa dữ liệu db put
    @PutMapping("/user/{id}")
    public UserUpdateOut update(@PathVariable long id, @RequestBody UserLoginIn userLoginIn) {
        return userService.update(id, userLoginIn);
    }

    // xóa dữ liệu
    @DeleteMapping("/user")
    public ResponseEntity<ResultService> delete(@RequestBody DeleteServices deleteServices) {
        return new ResponseEntity<ResultService>(userService.delete(deleteServices.getId()), HttpStatus.OK);
    }

//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<ResultService> delete(@PathVariable("id") long id) {
//        UserEntity userEntity = userService.findById(id);
//        if (userEntity == null) {
//            return new ResponseEntity<ResultService>(HttpStatus.NOT_FOUND);
//        }
//        userService.delete(id);
//        return new ResponseEntity<ResultService>(HttpStatus.NO_CONTENT);
//    }


    //login
//    @PostMapping("/login")
//    public UserLoginOut loginOut(@PathVariable String usurname, @RequestBody UserLoginOut userLoginOut) {
//        return  userService.login(usurname, userLoginOut);
//    }
}
