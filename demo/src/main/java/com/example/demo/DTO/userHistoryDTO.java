package com.example.demo.DTO;

import java.util.Date;

public class userHistoryDTO {
    private Long id;
    private int score;
    private Date datePicked;
    
    private Long userId;
    private String userName;

    private Long optionId;
    private String optionName;

    public userHistoryDTO() {
    }

    public userHistoryDTO(Long id, int score, Date datePicked, Long userId, String userName, Long optionId, String optionName) {
        this.id = id;
        this.score = score;
        this.datePicked = datePicked;
        this.userId = userId;
        this.userName = userName;
        this.optionId = optionId;
        this.optionName = optionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDatePicked() {
        return datePicked;
    }

    public void setDatePicked(Date datePicked) {
        this.datePicked = datePicked;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
