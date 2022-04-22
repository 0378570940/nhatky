package com.example.demo.models.dto;

public class DiaryDto {
    private Long id;
    private String name;
    private String des;
    private String content;
    private String image;
    private String userid;
    private String time;

    public DiaryDto() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DiaryDto(String id, String name, String des, String content, String image, String userid) {
        this.name = name;
        this.des = des;
        this.content = content;
        this.image = image;
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
