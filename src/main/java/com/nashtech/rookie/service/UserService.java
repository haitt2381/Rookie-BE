package com.nashtech.rookie.service;

import com.nashtech.rookie.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(int id);
    public User save(User user);
    public User deleteById(int id);
}
