package com.nashtech.rookie.service;

import com.nashtech.rookie.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(long id);
    User save(User user);
    User deleteById(long id);
}
