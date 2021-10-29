package com.nashtech.rookie.repository;

import com.nashtech.rookie.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void testCreateCategory(){
        Category category = new Category().builder()
                .content("dien thoai")
                .slug("dtdd")
                .title("Điện thoại di động")
                .categoryParent(null)
                .build();

         Assert.assertNotNull(categoryRepo.save(category));

    }

    @Test
    public void testGetAllCategory(){
        List<Category> categoryList = categoryRepo.findAll();
        Assert.assertNotNull(categoryList);
    }
}
