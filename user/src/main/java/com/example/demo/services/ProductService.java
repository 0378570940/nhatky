package com.example.demo.services;

import com.example.demo.entities.ProductEntity;
import com.example.demo.models.in.ProductIn;
import com.example.demo.models.out.ProductOut;
import com.example.demo.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepositories productRepositories;

    //thêm thông tin product vào db post
//    public ProductOut create(ProductEntity productEntity){
//        ProductOut productOut =new ProductOut();
//        productOut.setUpdate(productRepositories.save(pr));
//
//    }

    //sửa
    public ProductOut update(long id, ProductIn productIn) {
        ProductEntity productEntity = productRepositories.getById(id);
        if (productEntity != null) {
            productEntity.setName(productIn.getName());
            productEntity.setBrand(productIn.getBrand());
            productEntity.setPrice(productIn.getPrice());
            productEntity.getCategory(productIn.getCategory());
            productEntity.getDescription(productIn.getDescription());
            productRepositories.save(productEntity);
            return new ProductOut(true, "sửa thành công");
        }
        return new ProductOut(true, "sửa không thành công");
    }
}
