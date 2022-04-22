package com.example.demo.controller;

import com.example.demo.entity.DiaryEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.models.in.DiaryIn;
import com.example.demo.models.in.UserIn;
import com.example.demo.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalTime;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PostMapping("diary")
    public ResponseEntity<?> createDiary(@RequestBody DiaryEntity diaryEntity) {
        return diaryService.createDiary(diaryEntity);
    }

    @GetMapping("diary")
    public ResponseEntity<?> getDiary() {
        return diaryService.getDiary();
    }

    @PutMapping("diary/{id}")
    public ResponseEntity<?> updateDiary(@PathVariable(name = "id") long id, @RequestBody DiaryIn diaryIn) {
        return diaryService.updateDiary(id, diaryIn);
    }

    @DeleteMapping("diary/{id}")
    public ResponseEntity<?> deleteDiary(@PathVariable(name = "id") long id) {
        return diaryService.deleteDiary(id);
    }

    @PostMapping("image")
    public ResponseEntity<?> createImage(@RequestParam long id, @RequestParam("file") MultipartFile file) throws IOException {
        return diaryService.createImage(id, file);
    }

    @GetMapping("infoDiary/{id}")
    public ResponseEntity<?> getInfoDiary(@PathVariable(name = "id") long id) {
        return diaryService.getInfoDiary(id);
    }
//
//    @PostMapping("favorite")
//    public ResponseEntity<?> addInfoFavorite(@PathVariable(name = "id") Long id, @RequestBody UserIn userIn) {
//        return diaryService.addInfoFavorite(id, userIn);
//    }

    @PostMapping("user")
    public ResponseEntity<?> addInfoFavorites(@RequestHeader(name = "Authorization") String token) {
        return diaryService.addInfoFavorites(token);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getFilter(@PathVariable(name = "id") long id) {
        return diaryService.getFilter(id);
    }

    @PutMapping("theme/{id}")
    public ResponseEntity<?> updateFilter(@PathVariable long id, @RequestBody DiaryIn diaryIn) {
        return diaryService.updateTheme(id, diaryIn);
    }

    @PostMapping("time")
    public ResponseEntity<?> createTime(@RequestParam(name = "id") long id) {
        return diaryService.createTime(id);
    }
}
