package com.example.demo.service;

import com.example.demo.entity.DiaryEntity;
import com.example.demo.entity.ThemeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.DiaryMapper;
import com.example.demo.models.dto.DiaryDto;
import com.example.demo.models.dto.FavoriteDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.in.DiaryIn;
import com.example.demo.models.out.ThemeOut;
import com.example.demo.repositories.DiaryRepositories;
import com.example.demo.repositories.ThemeRepositories;
import com.example.demo.repositories.UserRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaryService {
    @Autowired
    private DiaryRepositories diaryRepositories;
    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private ThemeRepositories themeRepositories;
    @Autowired
    private DiaryMapper mapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtLoginService jwtLoginService;

    //thêm bài nhật ký mới
    public ResponseEntity<?> createDiary(DiaryEntity diaryEntity) {
        //thêm vào db
        DiaryDto diaryDto = mapper.createDiary(diaryRepositories.save(diaryEntity));
        return new ResponseEntity<>("thêm thành công !", HttpStatus.OK);
    }

    //lấy danh sách nhật ký của mình
    public ResponseEntity<?> getDiary() {
        //lấy thông tin từ db
        List<DiaryEntity> diaryEntityList = diaryRepositories.findAll();
        List<DiaryDto> diaryDtoList = diaryEntityList.stream()
                .map(s -> modelMapper.map(s, DiaryDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(diaryDtoList, HttpStatus.OK);
    }

    //xóa một nhật ký đã viết trước đó
    public ResponseEntity<?> deleteDiary(long id) {
        try {
            //xóa từ trong db
            diaryRepositories.deleteById(id);
            return new ResponseEntity<>("xóa thành công!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("không có thông tin nào chuyền vào, xóa không thành công!", HttpStatus.BAD_REQUEST);
        }
    }

    //cập nhật nội dung của nhật ký đó
    public ResponseEntity<?> updateDiary(long id, DiaryIn diaryIn) {
        //cập nhật lại trong db
        DiaryEntity diaryEntity = diaryRepositories.findAllById(id);
        //ktra lếu ko có thì trả ra kq
        if (diaryEntity == null)
            return new ResponseEntity<>("không có id nào để chuyền vào, cập nhật không thành công!", HttpStatus.BAD_REQUEST);
        diaryEntity = mapper.updateDiary(diaryEntity, diaryIn);
        diaryRepositories.save(diaryEntity);
        return new ResponseEntity<>("cập nhật thành công", HttpStatus.OK);
    }

    //thêm ảnh
    public ResponseEntity<?> createImage(long id, MultipartFile file) throws IOException {
        //thên ảnh vào db
        DiaryEntity diaryEntity = diaryRepositories.findAllById(id);
        //ktra lếu ko có thì trả ra kq
        if (diaryEntity == null) return new ResponseEntity<>("chưa cập nhật được ảnh", HttpStatus.BAD_REQUEST);
        diaryEntity.setId(id);
        diaryEntity.setImage(Arrays.toString(file.getBytes()));
        //lưu bản ghi vào cơ sở dữ liệu
        diaryRepositories.save(diaryEntity);
        return new ResponseEntity<>("thêm thành công !", HttpStatus.OK);
    }

    //người dùng tôi muốn xem lại một nhật ký đã thêm
    public ResponseEntity<?> getInfoDiary(long id) {
        //lấy thông tin từ db
        DiaryEntity diaryEntity = diaryRepositories.findAllById(id);
        UserEntity userEntity = userRepositories.findByUserId(id);
        //ktra lếu ko có thì trả ra kq
        if (diaryEntity == null || userEntity == null)
            return new ResponseEntity<>("không tìm thấy thông tin trong Diary!", HttpStatus.BAD_REQUEST);
        UserDto userDto = new UserDto();
        mapper.mapDiary(userDto, diaryEntity, userEntity);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //thêm nhật ký vào danh sách yêu thích
    public ResponseEntity<?> addInfoFavorites(String token) {
        //lấy id theo token
        long userId = Long.parseLong(jwtLoginService.parseToken(token));
        //lấy thông tin token trong db
        UserEntity userEntity = userRepositories.findByUserId(userId);
        DiaryEntity diaryEntity = diaryRepositories.findAllById(userId);
        //ktra nếu có thì trả ra kq
        if (userEntity == null || diaryEntity == null)
            return new ResponseEntity<>("khong co thong tin nao!", HttpStatus.NOT_FOUND);
        DiaryDto diaryDto = new DiaryDto();
        FavoriteDto favoriteDto = new FavoriteDto();
        favoriteDto.setUserid(userEntity.getUserId());
        mapper.mapFavorite(diaryDto, diaryEntity);
        favoriteDto.setFavorite(diaryDto);
        return new ResponseEntity<>(favoriteDto, HttpStatus.OK);
    }

    //lọc các nhật ký theo 1 chủ để
    public ResponseEntity<?> getFilter(long id) {
        //lấy thông tin từ b
        ThemeEntity themeEntity = themeRepositories.findAllByThemeId(id);
        DiaryEntity diaryEntity = diaryRepositories.findAllById(id);
        //ktra lếu có thì trả ra kq
        if (themeEntity == null || diaryEntity == null)
            return new ResponseEntity<>("không có thông tin nào của nhật ký và hủ đề!", HttpStatus.OK);
        ThemeOut themeOut = new ThemeOut();
        DiaryDto diaryDto = mapper.mapFilter(diaryEntity);
        themeOut.setThemeId(themeEntity.getThemeId());
        themeOut.setDescription(themeEntity.getDescription());
        themeOut.setThemename(themeEntity.getThemename());
        themeOut.setFilter(diaryDto);
        return new ResponseEntity<>(themeOut, HttpStatus.OK);
    }

    //cập nhật chủ đề của nhật ký
    public ResponseEntity<?> updateTheme(long id, DiaryIn diaryIn) {
        //cập nhật lại trong db
        ThemeEntity themeEntity = themeRepositories.findAllByThemeId(id);
        DiaryEntity diaryEntity = diaryRepositories.findAllById(id);
        //ktra nếu có thì trả ra kq
        if (diaryEntity == null || themeEntity == null)
            return new ResponseEntity<>("không có id nào để chuyền vào, cập nhật không thành công!", HttpStatus.BAD_REQUEST);
        mapper.updateTheme(diaryEntity, themeEntity, diaryIn);
        diaryRepositories.save(diaryEntity);
        themeRepositories.save(themeEntity);
        return new ResponseEntity<>("cập nhật thành công", HttpStatus.OK);
    }

    //thêm giờ hiện tại
    public ResponseEntity<?> createTime(long id){
        //thêm thông tin vào db
        DiaryEntity diaryEntity = diaryRepositories.findAllById(id);
        //ktra nếu có thì trả ra kq
        if (diaryEntity == null) return new ResponseEntity<>("chưa cập nhật được ảnh", HttpStatus.BAD_REQUEST);
        LocalTime now = LocalTime.now();
        diaryEntity.setId(id);
        diaryEntity.setTime(String.valueOf(now));
        diaryRepositories.save(diaryEntity);
        return new ResponseEntity<>("thêm thành công !", HttpStatus.OK);
    }
}
