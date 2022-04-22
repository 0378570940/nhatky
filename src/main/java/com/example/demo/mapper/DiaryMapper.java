package com.example.demo.mapper;

import com.example.demo.entity.DiaryEntity;
import com.example.demo.entity.ThemeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.models.dto.DiaryDto;
import com.example.demo.models.dto.LoginDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.in.DiaryIn;
import com.example.demo.models.out.ThemeOut;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class DiaryMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public UserDto createDiary(DiaryEntity diaryEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(diaryEntity.getId());
        userDto.setName(diaryEntity.getName());
        userDto.setContent(diaryEntity.getContent());
        userDto.setDes(diaryEntity.getDes());
        userDto.setUserid(diaryEntity.getUserid());
        userDto.setImage(diaryEntity.getImage());
        return userDto;
    }

    public DiaryEntity updateDiary(DiaryEntity diaryEntity, DiaryIn diaryIn) {
        diaryEntity.setName(diaryIn.getName());
        diaryEntity.setDes(diaryIn.getDes());
        diaryEntity.setContent(diaryIn.getContent());
        diaryEntity.setImage(diaryIn.getImage());
        diaryEntity.setUserid(String.valueOf(diaryIn.getUserid()));
        return diaryEntity;
    }

    public UserDto mapDiary(UserDto userDto, DiaryEntity diaryEntity, UserEntity userEntity) {
        userDto.setId(diaryEntity.getId());
        userDto.setName(diaryEntity.getName());
        userDto.setDes(diaryEntity.getDes());
        userDto.setContent(diaryEntity.getContent());
        userDto.setImage(diaryEntity.getImage());
        userDto.setUserId(Long.parseLong(diaryEntity.getUserid()));
        userDto.setUsername(userEntity.getUsername());
        userDto.setAdmin(userEntity.getAdmin());
        return userDto;
    }

    public LoginDto mapLogin(LoginDto loginDto, UserEntity userEntity) {
        loginDto.setAdmin(userEntity.getAdmin());
        loginDto.setPassword(userEntity.getPassword());
//        userDto.setToken(userEntity.getToken());
        return loginDto;
    }

    public DiaryDto mapFavorite(DiaryDto diaryDto, DiaryEntity diaryEntity) {
        diaryDto.setName(diaryEntity.getName());
        diaryDto.setDes(diaryEntity.getDes());
        diaryDto.setContent(diaryEntity.getContent());
        diaryDto.setImage(diaryEntity.getImage());
        diaryDto.setUserid(diaryEntity.getUserid());
        return diaryDto;
    }

    public DiaryDto mapFilter(DiaryEntity diaryEntity) {
        DiaryDto diaryDto = new DiaryDto();
        diaryDto.setId(diaryEntity.getId());
        diaryDto.setName(diaryEntity.getName());
        diaryDto.setDes(diaryEntity.getDes());
        diaryDto.setContent(diaryEntity.getContent());
        diaryDto.setImage(diaryEntity.getImage());
        diaryDto.setUserid(diaryEntity.getUserid());
        diaryDto.setTime(diaryEntity.getTime());
        return diaryDto;
    }

    public DiaryEntity updateTheme(DiaryEntity diaryEntity, ThemeEntity themeEntity, DiaryIn diaryIn) {
        diaryEntity.setName(diaryIn.getName());
        diaryEntity.setDes(diaryIn.getDes());
        diaryEntity.setContent(diaryIn.getContent());
        diaryEntity.setImage(diaryIn.getImage());
        diaryEntity.setUserid(String.valueOf(diaryIn.getUserid()));
        themeEntity.setDescription(diaryIn.getDescription());
        themeEntity.setThemename(diaryIn.getThemename());
        return diaryEntity;
    }

    public LoginDto mapLogout(UserEntity userEntity, LoginDto loginDto) {
        loginDto.setAdmin(userEntity.getAdmin());
        loginDto.setPassword(userEntity.getPassword());
        return loginDto;
    }
}
