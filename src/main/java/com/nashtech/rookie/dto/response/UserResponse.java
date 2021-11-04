package com.nashtech.rookie.dto.response;

import com.nashtech.rookie.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String image;
    private boolean gender;
    private Set<Role> roles;
}
