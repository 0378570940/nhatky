package com.example.demo.services;

import com.example.demo.entities.UserEntity;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.in.UserLoginIn;
import com.example.demo.models.out.UserUpdateOut;
import com.example.demo.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepositories userRepositories;

    //thêm vào db post
    public ResultService create(UserEntity userEntity) {
        ResultService resultService = new ResultService();
        resultService.setData(userRepositories.save(userEntity));
        return resultService;
    }


    //lấy dữ liệu từ db ra get
//    public ResultService findAll(){
//        ResultService resultService = new ResultService();
//        resultService.setData(userRepositories.findAll());
//        return resultService;
//    }

//    public List<UserDto> findAll(){
//        //lấy dữ liêu db
//        List<UserEntity> userEntityList= userRepositories.findAll();
//        //sửa lý dữu liệu
//        List<UserDto> listOfUpdate = new ArrayList<>();
//        for (UserEntity userEntity : userEntityList){
//        // biến cái userEntity thanh UserDto u
//            UserDto userDto = new UserDto();
//            userDto.setUserEmail(userEntity.getUserEmail());
//            userDto.setUserFullname(userEntity.getUserFullname());
//            userDto.setUserName(userEntity.getUserName());
//            userDto.setUserPassword(userEntity.getUserPassword());
//            userDto.setUserAge( userEntity.getUserAge());
//            listOfUpdate.add(userDto);
//        }
//        return listOfUpdate;
//    }

    public List<UserDto> findAll() {
        List<UserEntity> userEntityList = userRepositories.findAll();
        List<UserDto> userDtoList = userEntityList.stream()
                .map(p -> new UserDto(p.getUserName(), p.getUserFullname(), p.getUserEmail(), p.getUserPassword(), p.getId(), p.getUserAge()))
                .collect(Collectors.toList());
        return userDtoList;
    }


    //lấy id trong db get
    public ResultService findById(long id) {
        ResultService resultService = new ResultService();
        UserEntity userEntity = userRepositories.findById(id); //or
        resultService.setData(userEntity);
        return resultService;
    }

    //sủa trong db pus
    public UserUpdateOut update(long id, UserLoginIn userLoginIn) {
        //laays duwx xlieeu tu db
        UserEntity userEntity = userRepositories.findUserById(id);
        // chec du lieu co hay ko
        if (userEntity != null) {
            userEntity.setUserName(userLoginIn.getUserName());
            userEntity.setUserPassword(userLoginIn.getUserPassWord());
            userRepositories.save(userEntity);
            return new UserUpdateOut(true, "update success");
        }
        return new UserUpdateOut(false, "user not exist");
    }


    //xóa dữ liệu db
    public ResultService delete(long id) {
        ResultService resultService = new ResultService();
        UserEntity userEntity = userRepositories.findById(id).orElse(null);
        if (userEntity == null) {
            resultService.setStatus(ResultService.Status.FAILED);
            resultService.setMessage("thành công");
        } else {
            userRepositories.delete(userEntity);
            resultService.setMessage("không tìm thấy thông tin");
        }
        return resultService;
    }
//    public UserUpdateOut delete(long id, UserIn userIn) {
//        List<UserEntity> listUserEntity = userRepositories.deleteUserById(id);
//        for (UserEntity userEntity : listUserEntity) {
//                userEntity.setId(userIn.getId());
//                userRepositories.save(userEntity);
//            return new UserUpdateOut(true, "xóa thành công");
//        }
//        return new UserUpdateOut(true, "xóa không thành công");
//    }
}


//login
//    public com.example.demo.models.out.UserLoginOut login(String username, UserLoginOut userLoginOut){
//        UserEntity userEntity =userRepositories.findUserLoginInBy(username);
//        if( userEntity != null){
//            userLoginOut.setUserName(userEntity.getUserName());
//            userLoginOut.setUserFullname(userEntity.getUserFullname());
//            userLoginOut.setUserPassword(userEntity.getUserPassword());
//            userLoginOut.setUserEmail(userEntity.getUserEmail());
//            userRepositories.save(userEntity);
//            return new UserLoginOut(true, "dăng nhập thành công");
//        }else{
//            return new UserLoginOut(true, "dăng nhập thành công");
//        }
//    }

