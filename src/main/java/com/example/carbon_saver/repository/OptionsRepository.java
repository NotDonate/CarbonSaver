package com.example.carbon_saver.repository;

import com.example.carbon_saver.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OptionsRepository extends JpaRepository<Options, Integer> {
    Optional<Options> findByOptionName(String optionName);
}