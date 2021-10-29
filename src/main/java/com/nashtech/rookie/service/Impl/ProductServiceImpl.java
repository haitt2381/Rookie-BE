package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.entity.Product;
import com.nashtech.rookie.repository.ProductRepository;
import com.nashtech.rookie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

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
    public int deleteById(int id) {
        try{
            productRepository.deleteById(id);
            return id;
        }catch (Exception e){
            return -1;
        }
    }
}
