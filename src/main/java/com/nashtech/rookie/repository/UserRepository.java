package com.nashtech.rookie.repository;

import com.nashtech.rookie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}