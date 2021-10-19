package com.nashtech.rookie.service;

import com.nashtech.rookie.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    Product deleteById(int id);
}
