package com.nashtech.rookie.repository;

import com.nashtech.rookie.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void saveProduct(){
        Category category = new Category().builder().id(61).build();
        Product product = new Product().builder()
                .id(0)
                .slug("iphone-13")
                .name("Iphone 13")
                .summary("sumarry iphone")
                .discount(BigDecimal.valueOf(10.0))
                .publicShop(true)
                .createAt(new Date())
                .updateAt(null)
                .publicAt(new Date())
                .content("content Iphone")
                .build();
        product.addCategory(category);

        Assert.assertNotNull(productRepo.save(product));
    }

    @Test
    public void saveProductWithProductDetail(){
        Category category = categoryRepo.findById(61).get();

        Product product = new Product().builder()
                .id(0)
                .slug("iphone-132")
                .name("Iphone 132")
                .summary("sumarry iphone")
                .discount(BigDecimal.valueOf(10.0))
                .publicShop(true)
                .createAt(new Date())
                .updateAt(null)
                .publicAt(new Date())
                .content("content Iphone")
                .build();
        product.addCategory(category);
        ProductDetail productDetail = new ProductDetail().builder()
                .product(product)
                .color("Vàng")
                .memory("100GB")
                .stock(100)
                .price(BigDecimal.valueOf(100000))
                .build();

        product.addProductDetail(productDetail);

        Assert.assertNotNull(productRepo.save(product));
    }


    @Test
    public void testGetAllProduct(){
        List<Product> productList = productRepo.findAll();

        Assert.assertNotNull(productList);
    }
}
