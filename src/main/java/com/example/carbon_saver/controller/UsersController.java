package com.example.carbon_saver.controller;

import com.example.carbon_saver.entity.Users;
import com.example.carbon_saver.repository.UsersRepository;
import com.example.carbon_saver.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

public UsersController(UserService userService) {
    this.userService = userService;
}
    @GetMapping
public List<Users> getAllUsers() {
    return userService.getUsers();
}
    @GetMapping("/{id}")
public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
    return userService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

    @GetMapping("/findByEmail")
public ResponseEntity<Users> getUserByEmail(@RequestParam String email) {
    return userService.findByEmail(email)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
    @PostMapping
public Users createUser(@RequestBody Users user) {
    return userService.addUser(user);
}

    @DeleteMapping("/{id}")
public void deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
}
}