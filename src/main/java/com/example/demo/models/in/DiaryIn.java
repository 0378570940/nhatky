package com.example.demo.models.in;

public class DiaryIn extends ThemeIn{
    private Long id;
    private String name;
    private String des;
    private String content;
    private String image;
    private Long userid;

    public DiaryIn() {
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public DiaryIn(Long id, String name, String des, String content, String image, Long userid) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.content = content;
        this.image = image;
        this.userid = userid;
    }
}
