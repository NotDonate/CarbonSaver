package com.example.demo.Repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.userChoiceHistory;

public interface userhistoryrepository extends CrudRepository<userChoiceHistory, Long> {
    List<userChoiceHistory> findByUserId(Long userId);
}
