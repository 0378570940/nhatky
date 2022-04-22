package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.DiaryMapper;
import com.example.demo.models.dto.LoginDto;
import com.example.demo.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {
    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private DiaryMapper mapper;

    public ResponseEntity<?> logoutUser(String token){
        //lấy thông tin từ db
        UserEntity userEntity =userRepositories.findAllByToken(token);
        //ktra nếu có thì trả ra kq
        if(userEntity == null) return new ResponseEntity<>("đăng xuất ko thành công!", HttpStatus.NOT_FOUND);
        LoginDto loginDto = new LoginDto();
        mapper.mapLogout(userEntity,loginDto);
        return new ResponseEntity<>("đăng xuất thành công!", HttpStatus.OK);
    }
}
