package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.entity.Order;
import com.nashtech.rookie.repository.OrderRepository;
import com.nashtech.rookie.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public int deleteById(int id) {
        try{
            orderRepository.deleteById(id);
            return id;
        }catch (Exception e){
            return -1;
        }
    }
}
