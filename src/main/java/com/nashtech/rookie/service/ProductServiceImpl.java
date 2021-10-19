package com.nashtech.rookie.service;

import com.nashtech.rookie.model.Product;
import com.nashtech.rookie.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements IProductService{

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteById(int id) {
        Product product = this.findById(id);
        if(product != null){
            productRepository.deleteById(id);
        }
        return product;
    }
}
