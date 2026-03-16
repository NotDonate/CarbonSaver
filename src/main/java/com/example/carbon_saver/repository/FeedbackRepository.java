package com.example.carbon_saver.repository;

import com.example.carbon_saver.entity.Feedback;
import com.example.carbon_saver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByUser(Users user);
}