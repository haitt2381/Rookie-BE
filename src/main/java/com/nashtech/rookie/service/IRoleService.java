package com.nashtech.rookie.service;

import com.nashtech.rookie.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findById(int id);
    Role save(Role role);
    Role deleteById(int id);
}
