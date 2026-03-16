package com.example.carbon_saver.repository;

import com.example.carbon_saver.entity.UserChoiceHistory;
import com.example.carbon_saver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChoiceHistoryRepository extends JpaRepository<UserChoiceHistory, Integer> {
    List<UserChoiceHistory> findByUser(Users user);
}