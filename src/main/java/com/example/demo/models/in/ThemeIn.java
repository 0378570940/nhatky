package com.example.demo.models.in;

public class ThemeIn {
    private long themeId;
    private String themename;
    private String description;

    public ThemeIn() {
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

    public ThemeIn(long themeId, String themename, String description) {
        this.themeId = themeId;
        this.themename = themename;
        this.description = description;
    }
}
