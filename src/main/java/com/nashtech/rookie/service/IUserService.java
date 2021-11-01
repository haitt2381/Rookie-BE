package com.nashtech.rookie.service;

import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.dto.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    UserResponse findById(long id);
    User save(User user);
    User deleteById(long id);
    List<User> findAll();
}
