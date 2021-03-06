package com.nashtech.rookie.repository;

import com.nashtech.rookie.entity.Role;
import com.nashtech.rookie.constant.URole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(URole name);
}
