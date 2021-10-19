package com.nashtech.rookie;

import com.nashtech.rookie.repository.UserRepository;
import com.nashtech.rookie.service.IUserService;
import com.nashtech.rookie.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//@SpringBootTest
public class UserServiceTest {
    @Mock
    IUserService iUserService;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void whenGetAll_shouldReturnList(){
//        System.out.println(userService.getAllUser());
    }
}
