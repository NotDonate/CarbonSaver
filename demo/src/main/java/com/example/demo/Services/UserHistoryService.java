package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repos.userhistoryrepository;
import com.example.demo.Model.userChoiceHistory;

@Service
public class UserHistoryService {
    @Autowired
    private userhistoryrepository userhistoryrepository;
    public userChoiceHistory saveUserChoiceHistory(userChoiceHistory history) {
        return userhistoryrepository.save(history);
    }
    public Iterable<userChoiceHistory> getAllUserChoiceHistories() {
        return userhistoryrepository.findAll();
    }
    public void deleteUserChoiceHistory(Long id) {
        userhistoryrepository.deleteById(id);
    }
    public userChoiceHistory getUserChoiceHistoryById(Long id) {
        return userhistoryrepository.findById(id).orElse(null);
    }
}
