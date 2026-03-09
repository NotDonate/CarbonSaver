package com.example.carbon_saver.repository;

import com.example.carbon_saver.entity.UserChoiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChoiceHistoryRepository extends JpaRepository<UserChoiceHistory, Integer> {
}