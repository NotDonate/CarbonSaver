package com.example.carbon_saver.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "User_Choice_History")
public class UserChoiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "options_id", nullable = false)
    private Options option;

    @ManyToOne
    @JoinColumn(name = "user_information_id", nullable = true)
    private UserInformation userInformation;

    @Column(name = "date_picked")
    private LocalDate datePicked;

    private Integer score;

    public UserChoiceHistory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public LocalDate getDatePicked() {
        return datePicked;
    }

    public void setDatePicked(LocalDate datePicked) {
        this.datePicked = datePicked;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}