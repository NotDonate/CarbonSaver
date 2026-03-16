package com.example.carbon_saver.service;

import com.example.carbon_saver.entity.Options;
import com.example.carbon_saver.entity.UserChoiceHistory;
import com.example.carbon_saver.entity.Users;
import com.example.carbon_saver.repository.OptionsRepository;
import com.example.carbon_saver.repository.UserChoiceHistoryRepository;
import com.example.carbon_saver.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import java.util.List;
import com.example.carbon_saver.entity.UserChoiceHistory;

import com.example.carbon_saver.entity.Feedback;
import com.example.carbon_saver.repository.FeedbackRepository;
import java.time.LocalDateTime;
import java.util.List;



@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final OptionsRepository optionsRepository;
    private final UserChoiceHistoryRepository userChoiceHistoryRepository;
    private final FeedbackRepository feedbackRepository;

    public UserService(
        UsersRepository usersRepository,
        OptionsRepository optionsRepository,
        UserChoiceHistoryRepository userChoiceHistoryRepository,
        FeedbackRepository feedbackRepository) {
    this.usersRepository = usersRepository;
    this.optionsRepository = optionsRepository;
    this.userChoiceHistoryRepository = userChoiceHistoryRepository;
    this.feedbackRepository = feedbackRepository;
}
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public List<UserChoiceHistory> getUserHistory(Integer id) {
    Users user = usersRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    return userChoiceHistoryRepository.findByUser(user);
}

    public Optional<Users> findById(Integer id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    public UserChoiceHistory saveEmailedOption(String email, String optionName) {
        Users user = usersRepository.findByEmail(email).orElseGet(() -> {
            Users newUser = new Users();
            newUser.setName(email);
            newUser.setEmail(email);
            newUser.setPassword("temporary");
            newUser.setUserType("guest");
            newUser.setCreatedAt(LocalDateTime.now());
            newUser.setUpdatedAt(LocalDateTime.now());
            return usersRepository.save(newUser);
        });

        Options option = optionsRepository.findByOptionName(optionName)
                .orElseThrow(() -> new RuntimeException("Option not found: " + optionName));

        UserChoiceHistory history = new UserChoiceHistory();
        history.setUser(user);
        history.setOption(option);
        history.setDatePicked(LocalDate.now());
        history.setScore(0);

        // only set this if you have a questionnaire row
        history.setUserInformation(null);

        return userChoiceHistoryRepository.save(history);
    }
    public Feedback saveFeedback(String email, String feedbackText, Integer rating) {
    Users user = usersRepository.findByEmail(email).orElseGet(() -> {
        Users newUser = new Users();
        newUser.setName(email);
        newUser.setEmail(email);
        newUser.setPassword("temporary");
        newUser.setUserType("guest");
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());
        return usersRepository.save(newUser);
    });

    Feedback feedback = new Feedback();
    feedback.setUser(user);
    feedback.setDateSent(LocalDateTime.now());
    feedback.setFeedbackText(feedbackText);
    feedback.setRating(rating);

    return feedbackRepository.save(feedback);
}
public List<Feedback> getUserFeedback(Integer id) {
    Users user = usersRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    return feedbackRepository.findByUser(user);
}
}