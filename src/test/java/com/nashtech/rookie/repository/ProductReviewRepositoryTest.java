package com.nashtech.rookie.repository;

import com.nashtech.rookie.entity.Product;
import com.nashtech.rookie.entity.ProductReview;
import com.nashtech.rookie.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductReviewRepositoryTest {
  @Autowired
  ProductReviewRepository reviewRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  ProductRepository productRepository;


  @Test
  public void testSaveReview() {
    User userReview = userRepository.getById(41L);
    Product product = productRepository.getById(81);
    ProductReview review =
        new ProductReview()
            .builder()
            .content("Sản phẩm xịn")
            .rating(5)
            .createdAt(new Date())
            .title("review sản phẩm iphone 13")
            .user(userReview)
            .product(product)
            .build();

    Assert.assertNotNull(reviewRepository.save(review));
  }
}
