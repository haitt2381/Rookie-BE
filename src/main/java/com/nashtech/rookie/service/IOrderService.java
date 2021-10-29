package com.nashtech.rookie.service;

import com.nashtech.rookie.entity.Order;

import java.util.List;

public interface IOrderService{
    List<Order> findAll();
    Order findById(int id);
    Order save(Order order);
    int deleteById(int id);
}
