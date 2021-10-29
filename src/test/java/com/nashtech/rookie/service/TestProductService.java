package com.nashtech.rookie.service;

import com.nashtech.rookie.entity.Product;
import com.nashtech.rookie.repository.ProductRepository;
import com.nashtech.rookie.service.Impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.*;

public class TestProductService {
  List<Product> products = new ArrayList<>();
  @Mock ProductRepository productRepository;
  @InjectMocks IProductService productService = new ProductServiceImpl();

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    dummyData();
  }

  @Test
  public void getAllProductsTest() {
    when(productRepository.findAll()).thenReturn(products);
    List<Product> productList = productService.findAll();
    Assert.assertEquals(3, productList.size());
    verify(productRepository, times(1)).findAll();
  }

  @Test
  public void getProductByIdTest()
  {
    when(productRepository.findById(0)).thenReturn(Optional.ofNullable(products.get(0)));
    Product product = productService.findById(0);

    Assert.assertEquals("iphone-13", product.getSlug());
    Assert.assertEquals("Iphone 13", product.getName());
  }

  @Test
  public void saveProductTest()
  {
    Product product = products.get(0);


    productService.save(product);

    verify(productRepository, times(1)).save(product);
  }


  private void dummyData() {
    Product product1 =
        new Product()
            .builder()
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
    Product product2 =
        new Product()
            .builder()
            .id(1)
            .slug("sam-sung")
            .name("sam sung galaxy")
            .summary("summary sam sung")
                .discount(BigDecimal.valueOf(10.0))
            .publicShop(true)
            .createAt(new Date())
            .updateAt(null)
            .publicAt(new Date())
            .content("content Iphone")
            .build();
    Product product3 =
        new Product()
            .builder()
            .id(3)
            .slug("oppo")
            .name("Oppo")
            .summary("summary oppo")
                .discount(BigDecimal.valueOf(10.0))
            .publicShop(true)
            .createAt(new Date())
            .updateAt(null)
            .publicAt(new Date())
            .content("content Iphone")
            .build();

    products.add(product1);
    products.add(product2);
    products.add(product3);
  }
}
