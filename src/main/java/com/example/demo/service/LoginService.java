package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.DiaryMapper;
import com.example.demo.models.dto.LoginDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.in.UserIn;
import com.example.demo.repositories.UserRepositories;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private JwtLoginService jwtLoginService;
    @Autowired
    private DiaryMapper mapper;

    //đăng nhập user và lấy token
    public ResponseEntity<?> loginUser(UserIn userIn){
        //thên vào db
        UserEntity userEntity = userRepositories.findByAdmin(userIn.getAdmin());
        //ktra password có thì trả ra kq
        if (!userIn.getPassword().equals(userEntity.getPassword())) {
            return new ResponseEntity<>("Mặt khẩu không tồn tại", HttpStatus.NOT_FOUND);
        }
        LoginDto loginDto = new LoginDto();
        mapper.mapLogin(loginDto, userEntity);
        //in ra token
        String token = jwtLoginService.generateJwtToken(userEntity);
        loginDto.setToken(token);
        return new ResponseEntity<>(loginDto,HttpStatus.OK);
    }
}
