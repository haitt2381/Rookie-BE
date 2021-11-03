package com.nashtech.rookie.service;

import com.nashtech.rookie.constant.URole;
import com.nashtech.rookie.entity.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role findByName(URole name);
    List<Role> findAll();
    Role findById(int id);
    Role save(Role role);
    Role deleteById(int id);
}
