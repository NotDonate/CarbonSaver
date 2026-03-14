package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repos.userrepository;
import com.example.demo.Model.user;

@Service
public class UserService {
    @Autowired
    private userrepository userrepository;
    public user findByEmail(String email) {
        return userrepository.findByEmail(email);
    }
    public user saveUser(user user) {
        return userrepository.save(user);
    }
    public Iterable<user> getAllUsers() {
        return userrepository.findAll();
    }
    public void deleteUser(Long id) {
        userrepository.deleteById(id);
    }
    public user updateUser(Long id, user updatedUser) {
        return userrepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userrepository.save(user);
        }).orElseGet(() -> {
            updatedUser.setId(id);
            return userrepository.save(updatedUser);
        });
    }
    public user getUserById(Long id) {
        return userrepository.findById(id).orElse(null);
    }

}
