package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.constant.ErrorMessage;
import com.nashtech.rookie.constant.URole;
import com.nashtech.rookie.dto.request.RegisterRequest;
import com.nashtech.rookie.entity.Role;
import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.dto.response.UserResponse;
import com.nashtech.rookie.exception.DuplicateDataException;
import com.nashtech.rookie.repository.RoleRepository;
import com.nashtech.rookie.repository.UserRepository;
import com.nashtech.rookie.service.IRoleService;
import com.nashtech.rookie.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
  private final ModelMapper mapper;
  private final UserRepository userRepository;
  private final IRoleService roleService;

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
    if (userRepository.existsByUsername(registerRequest.getUsername())) {
      throw new DuplicateDataException(ErrorMessage.ERROR_DUPLICATE_USERNAME.name());
    }

    if (userRepository.existsByEmail(registerRequest.getEmail())) {
      throw new DuplicateDataException(ErrorMessage.ERROR_DUPLICATE_EMAIL.name());
    }

    User user = new User().builder()
            .username(registerRequest.getUsername())
            .password(registerRequest.getPassword())
            .email(registerRequest.getEmail())
            .build();

    Set<String> strRoles = registerRequest.getRoles();

    if(strRoles == null){
      Role userRole = roleService.findByName(URole.ROLE_CUSTOMER);
      user.addRole(userRole);
    }else{
      strRoles.forEach(
              role -> {
                switch (role){
                  case "admin":
                    Role adminRole = roleService.findByName(URole.ROLE_ADMIN);
                    user.addRole(adminRole);
                    break;
                  case "user":
                    Role userRole = roleService.findByName(URole.ROLE_USER);
                    user.addRole(userRole);
                    break;
                  default:
                    Role customerRole = roleService.findByName(URole.ROLE_CUSTOMER);
                    user.addRole(customerRole);
                }
              }
      );
    }

    userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =
        userRepository
            .findByUsername(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username));

    return user;
  }
}
