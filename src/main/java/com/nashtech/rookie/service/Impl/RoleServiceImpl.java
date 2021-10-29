package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.entity.Role;
import com.nashtech.rookie.repository.RoleRepository;
import com.nashtech.rookie.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role deleteById(int id) {
        Role role = findById(id);
        roleRepository.delete(role);
        return role;
    }
}