package com.example.demo.Repos;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.userChoiceHistory;

public interface userhistoryrepository extends CrudRepository<userChoiceHistory, Long> {
}
