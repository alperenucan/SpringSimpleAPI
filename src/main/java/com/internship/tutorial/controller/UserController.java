package com.internship.tutorial.controller;

import com.internship.tutorial.model.User;
import com.internship.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable("id") Long id){
        User user = userService.getUserbyID(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
        userService.updateUser(id,user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("v1/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Entity deleted");
    }
}
