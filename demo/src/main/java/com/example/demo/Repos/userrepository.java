package com.example.demo.Repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.user;

public interface userrepository extends CrudRepository<user, Long> {
    user findByEmail(String email);
}

