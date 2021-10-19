package com.nashtech.rookie.repository;

import com.nashtech.rookie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
