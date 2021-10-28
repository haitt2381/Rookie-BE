package com.nashtech.rookie.payload.response;

import com.nashtech.rookie.model.Role;
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
    private boolean gender;
    private Set<Role> roles;
}