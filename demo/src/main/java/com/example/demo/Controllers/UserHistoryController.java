package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Services.UserHistoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.userChoiceHistory;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/userhistory")
public class UserHistoryController {
    @Autowired
    private UserHistoryService userHistoryService;

    @PostMapping
    public void saveUserChoiceHistory(@RequestBody userChoiceHistory history) {
        userHistoryService.saveUserChoiceHistory(history);
        
    }

    @GetMapping
    public Iterable<com.example.demo.Model.userChoiceHistory> getAllUserChoiceHistories() {
        return userHistoryService.getAllUserChoiceHistories();
    }   

    @DeleteMapping("/{id}")
    public void deleteUserChoiceHistory(@PathVariable Long id) {
        userHistoryService.deleteUserChoiceHistory(id);
    }

    @GetMapping("/{id}")
    public userChoiceHistory getUserChoiceHistoryById(@PathVariable Long id) {
        return userHistoryService.getUserChoiceHistoryById(id);
    }
    
    
}
