package com.example.carbon_saver.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "option_name", nullable = false)
    private String optionName;

    public Options() {
    }

    public Options(String optionName) {
        this.optionName = optionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}