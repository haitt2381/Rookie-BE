package com.nashtech.rookie.service;

import com.nashtech.rookie.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    User deleteById(int id);
}
