package com.nashtech.rookie.service.Impl;

import com.nashtech.rookie.constant.ErrorMessage;
import com.nashtech.rookie.constant.URole;
import com.nashtech.rookie.entity.Role;
import com.nashtech.rookie.exception.ResourceNotFoundException;
import com.nashtech.rookie.repository.RoleRepository;
import com.nashtech.rookie.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

  @Autowired private RoleRepository roleRepository;

  @Override
  public Role findByName(URole roleName) {
    Role role =
        roleRepository
            .findByName(roleName)
            .orElseThrow(
                () -> new ResourceNotFoundException(ErrorMessage.ERROR_NOT_FOUND_ROLE.name()));
    return role;
  }

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
