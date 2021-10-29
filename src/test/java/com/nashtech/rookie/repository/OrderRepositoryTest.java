package com.nashtech.rookie.repository;

import com.nashtech.rookie.entity.Order;
import com.nashtech.rookie.entity.OrderDetail;
import com.nashtech.rookie.entity.Product;
import com.nashtech.rookie.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveRepository(){
        User user = userRepository.findById(41L).get();
        Product product = productRepository.findById(73).get();
    Order order = new Order().builder()
            .id(0)
            .note("Hẻm 63")
            .total(BigDecimal.valueOf(10000000))
            .customer(user)
            .createDate(new Date())
            .recipientName("Hair")
            .phoneNumber("091238124")
            .email("tranhai@gmail.com")
            .address("tan binh, tphcm")
            .build();

        OrderDetail orderDetail = new OrderDetail().builder()
                .order(order)
                .product(product)
                .quantity(2)
                .price(BigDecimal.valueOf(2000))
                .build();


        order.addOrderDetail(orderDetail);

        orderRepository.save(order);
    }
}
