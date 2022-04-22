package com.example.demo.entity;

import javax.persistence.*;

@Table
@Entity(name = "theme")
public class ThemeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long themeId;
    @Column(name = "themeName")
    private String themename;
    @Column(name = "description")
    private String description;

    public ThemeEntity() {
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

    public void setDescription(String descriptio) {
        this.description = descriptio;
    }
}
