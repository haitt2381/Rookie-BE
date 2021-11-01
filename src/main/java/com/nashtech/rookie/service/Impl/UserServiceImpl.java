package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.constant.ErrorMessage;
import com.nashtech.rookie.dto.request.RegisterRequest;
import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.dto.response.UserResponse;
import com.nashtech.rookie.exception.DuplicateDataException;
import com.nashtech.rookie.repository.UserRepository;
import com.nashtech.rookie.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
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

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        if(userRepository.existsByUsername(registerRequest.getUsername())){
            throw new DuplicateDataException(ErrorMessage.ERROR_DUPLICATE_USERNAME.name());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found with username: "+username));

        return user;
    }
}
