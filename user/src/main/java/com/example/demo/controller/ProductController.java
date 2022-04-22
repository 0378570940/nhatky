package com.example.demo.controller;

import com.example.demo.models.in.ProductIn;
import com.example.demo.models.out.ProductOut;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class ProductController {
    @Autowired
    private ProductService productService;

//    @PostMapping("product")
//    public ProductOut create(ProductIn productIn) {
//        return productService.create(productIn);
//    }

    //sửa thông tin
    @PutMapping("product")
    public ProductOut updates(long id, ProductIn productIn) {
        return productService.update(id, productIn);
    }
}
