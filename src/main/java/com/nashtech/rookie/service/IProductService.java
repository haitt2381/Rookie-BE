package com.nashtech.rookie.service;

import com.nashtech.rookie.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    int deleteById(int id);
}
