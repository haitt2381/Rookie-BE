package com.nashtech.rookie.service;

import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.payload.response.UserResponse;

import java.util.List;

public interface IUserService {
    UserResponse findById(long id);
    User save(User user);
    User deleteById(long id);
    List<User> findAll();
}
