package com.example.carbon_saver.controller;

import com.example.carbon_saver.entity.Users;
import com.example.carbon_saver.repository.UsersRepository;
import com.example.carbon_saver.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.carbon_saver.dto.SendOptionRequest;
import com.example.carbon_saver.entity.UserChoiceHistory;

import com.example.carbon_saver.entity.UserChoiceHistory;


import com.example.carbon_saver.dto.FeedbackRequest;
import com.example.carbon_saver.entity.Feedback;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")

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
@GetMapping("/{id}/history")
public ResponseEntity<List<UserChoiceHistory>> getUserHistory(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getUserHistory(id));
}
@GetMapping("/{id}/feedback")
public ResponseEntity<List<Feedback>> getUserFeedback(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getUserFeedback(id));
}
@PostMapping("/save-feedback")
public ResponseEntity<Feedback> saveFeedback(@RequestBody FeedbackRequest request) {
    Feedback saved = userService.saveFeedback(
            request.getEmail(),
            request.getFeedbackText(),
            request.getRating()
    );
    return ResponseEntity.ok(saved);
}
    @PostMapping
public Users createUser(@RequestBody Users user) {
    return userService.addUser(user);
}
    @PostMapping("/save-option")
    public ResponseEntity<UserChoiceHistory> saveOption(@RequestBody SendOptionRequest request) {
    UserChoiceHistory saved = userService.saveEmailedOption(
            request.getEmail(),
            request.getOptionName()
    );
    return ResponseEntity.ok(saved);
}

    @DeleteMapping("/{id}")
public void deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
}
}