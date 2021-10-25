package com.nashtech.rookie.service;

import com.nashtech.rookie.model.User;
import com.nashtech.rookie.payload.response.UserResponse;
import com.nashtech.rookie.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final ModelMapper mapper;
    private UserRepository userRepository;

    public UserService(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserResponse findById(long id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }

    public User save(User user) {
        System.out.println("==="+user);
        return userRepository.save(user);
    }

    public User deleteById(long id) {
//        User user = findById(id);
        User user = null;
        userRepository.delete(user);
        return user;
    }
}
