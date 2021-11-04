package com.nashtech.rookie.controller.user;

import com.nashtech.rookie.constant.SuccessMessage;
import com.nashtech.rookie.dto.wrapper.AbstractResponse;
import com.nashtech.rookie.dto.wrapper.SuccessResponse;
import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.dto.response.UserResponse;
import com.nashtech.rookie.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/users")
public class UserController {
  final IUserService userService;

  @Operation(summary = "Create a user", description = "Returns a user created, just admin role")
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    try {
      User userCreated = userService.save(user);
      return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "Find all users", description = "Returns a list users")
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("")
  AbstractResponse getAllUsers() {

    List<UserResponse> users = userService.findAll();

    if (users.isEmpty()) {
      return new SuccessResponse(
          HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase(), null);
    }

    return new SuccessResponse(
        HttpStatus.OK.value(), SuccessMessage.SUCCESS_GET_ALL_USERS.name(), users);
  }

  @Operation(summary = "Find user by username", description = "Returns a user")
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  @GetMapping("/{id}")
  AbstractResponse getUserById(@PathVariable("id") String id) {

    UserResponse userData = userService.findById(id);
    return new SuccessResponse(
        HttpStatus.OK.value(), SuccessMessage.SUCCESS_FIND_ID_USER.name(), userData);
  }

  @Operation(summary = "Update by username", description = "Returns a user updated")
  @PreAuthorize("hasRole('USER')")
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {

    //        User _user = userService.findById(Integer.parseInt(id));
    User _user = null;
    if (_user != null) {
      return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Operation(summary = "Delete by username", description = "Returns no_")
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
    try {
      userService.deleteById(Integer.parseInt(id));
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
