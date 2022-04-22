package com.example.demo.models.out;

public class ProductOut {

    private boolean isUpdate;
    private String message;


    public ProductOut(boolean b, String thêm_thành_công) {
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
