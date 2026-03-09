package com.example.carbon_saver.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "User_Information")
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users user;

    @Column(name = "user_class")
    private Integer userClass;

    private Integer budget;

    private Boolean rent;

    @Column(name = "information_at_date")
    private LocalDate informationAtDate;

    public UserInformation() {
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

    public Integer getUserClass() {
        return userClass;
    }

    public void setUserClass(Integer userClass) {
        this.userClass = userClass;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Boolean getRent() {
        return rent;
    }

    public void setRent(Boolean rent) {
        this.rent = rent;
    }

    public LocalDate getInformationAtDate() {
        return informationAtDate;
    }

    public void setInformationAtDate(LocalDate informationAtDate) {
        this.informationAtDate = informationAtDate;
    }
}