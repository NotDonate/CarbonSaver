package com.example.carbon_saver.dto;

public class SendOptionRequest {
    private String email;
    private String optionName;

    public SendOptionRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}