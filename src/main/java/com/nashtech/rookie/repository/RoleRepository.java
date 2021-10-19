package com.nashtech.rookie.repository;

import com.nashtech.rookie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
