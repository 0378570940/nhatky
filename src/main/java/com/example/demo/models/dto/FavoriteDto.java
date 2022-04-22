package com.example.demo.models.dto;

public class FavoriteDto{
    private long userid;
    private Object favorite;

    public FavoriteDto(Object favorite) {
        this.favorite = favorite;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public FavoriteDto() {
    }

    public Object getFavorite() {
        return favorite;
    }

    public void setFavorite(Object favorite) {
        this.favorite = favorite;
    }
}
