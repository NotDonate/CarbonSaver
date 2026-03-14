package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.user;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public Iterable<user> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Create a new user
    @PostMapping
    public user createUser(@RequestBody user u) {
        return userService.saveUser(u);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public user updateUser(@PathVariable Long id, @RequestBody user u) {
        return userService.updateUser(id, u);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Find user by email
    @GetMapping("/search")
    public user findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }
}