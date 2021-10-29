package com.nashtech.rookie.repository;

import com.nashtech.rookie.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
