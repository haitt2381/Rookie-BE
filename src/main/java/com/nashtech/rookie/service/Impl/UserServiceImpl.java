package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.payload.response.UserResponse;
import com.nashtech.rookie.repository.UserRepository;
import com.nashtech.rookie.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final ModelMapper mapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse findById(long id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public User save(User user) {
        System.out.println("==="+user);
        return userRepository.save(user);
    }

    @Override
    public User deleteById(long id) {
//        User user = findById(id);
        User user = null;
        userRepository.delete(user);
        return user;
    }
}
