package com.example.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot_beginner.models.User;
import com.example.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllusers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User temp = userService.getUserById(id);
        if(temp != null){
            return ResponseEntity.ok(temp);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public User addUser(@RequestBody User newUser){
        return userService.addUser(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateuser(@PathVariable int id, @RequestBody User updatedUser){
        User temp = userService.updateUser(id, updatedUser);
        if(temp != null){
            return ResponseEntity.ok(temp);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id){
        Boolean temp = userService.deleteUser(id);
        if(temp == true){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }
}
