package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repos.optionsrepository;
import com.example.demo.Repos.userrepository;
import com.example.demo.Model.user;
import com.example.demo.Model.options;
import com.example.demo.Repos.userhistoryrepository;
import com.example.demo.Model.userChoiceHistory;


@Component
public class Databaseinit implements org.springframework.boot.CommandLineRunner {
@Autowired
private userrepository userrepository;
@Autowired
private optionsrepository optionsrepository;   
@Autowired
private userhistoryrepository userhistoryrepository;
    @Override
    public void run(String... args) throws Exception {
        userrepository.deleteAll();
        user u1 = new user("John", "john@example.com", "password123");
        userrepository.save(u1);

        optionsrepository.deleteAll();
        options o1 = new options("Public Transport");
        optionsrepository.save(o1);

        userhistoryrepository.deleteAll();
        userChoiceHistory uch1 = new userChoiceHistory(10);
        uch1.setUser(u1);
        uch1.setOption(o1);
        userhistoryrepository.save(uch1);

    }
}


