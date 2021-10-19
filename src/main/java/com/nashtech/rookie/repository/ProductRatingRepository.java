package com.nashtech.rookie.repository;

import com.nashtech.rookie.model.ProductRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRatingRepository extends JpaRepository<ProductRating, Integer> {
}
