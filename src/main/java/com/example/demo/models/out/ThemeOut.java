package com.example.demo.models.out;

import com.example.demo.models.dto.DiaryDto;

import javax.persistence.Column;

public class ThemeOut {
    private long themeId;
    private String themename;
    private String description;
    private Object filter;

    public ThemeOut() {
    }

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }

    public String getThemename() {
        return themename;
    }

    public void setThemename(String themename) {
        this.themename = themename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }
}
