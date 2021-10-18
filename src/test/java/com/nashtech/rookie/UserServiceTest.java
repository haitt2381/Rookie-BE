package com.nashtech.rookie;

import com.nashtech.rookie.model.User;
import com.nashtech.rookie.repository.UserRepository;
import com.nashtech.rookie.service.UserService;
import com.nashtech.rookie.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
public class UserServiceTest {
    @Mock
    UserService iUserService;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void whenGetAll_shouldReturnList(){
//        System.out.println(userService.getAllUser());
    }
}
