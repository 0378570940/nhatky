package com.example.demo.models.out;

public class UserUpdateOut {
    private boolean isUpdate;
    private String message;

    public UserUpdateOut() {
    }

    public UserUpdateOut(boolean isUpdate, String message) {
        this.isUpdate = isUpdate;
        this.message = message;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
