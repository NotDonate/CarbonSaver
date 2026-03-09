package com.example.carbon_saver.repository;

import com.example.carbon_saver.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
}