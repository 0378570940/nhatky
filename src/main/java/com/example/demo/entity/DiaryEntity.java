package com.example.demo.entity;

import javax.persistence.*;

@Table
@Entity(name = "diary")
public class DiaryEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "des")
    private String des;
    @Column(name = "content")
    private String content;
    @Column(name = "image")
    private String image;
    @Column(name = "time")
    private String time;
    @Column(name = "userid")
    private String userid;

    public DiaryEntity() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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

    public void setName(String diaryName) {
        this.name = diaryName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String describe) {
        this.des = describe;
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
}
