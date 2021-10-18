package com.nashtech.rookie.controller;

import com.nashtech.rookie.model.User;
import com.nashtech.rookie.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try {
            User _user = userService.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> users = new ArrayList<>();
            users = userService.findAll();
            if(users.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Find user by username",
                description = "Returns a user, this can only be done by admin",
                tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Username not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        User userData = userService.findById(id);
        if(userData != null){
            return new ResponseEntity<>(userData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user){
        User _user = userService.findById(id);

        if(_user != null){
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id){
        try{
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
