package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@AllArgsConstructor

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found with username: "+username));

        return UserDetailsImpl.build(user);
    }
}
