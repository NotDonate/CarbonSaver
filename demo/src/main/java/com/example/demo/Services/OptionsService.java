package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repos.optionsrepository;
import com.example.demo.Model.options;

@Service
public class OptionsService {
    @Autowired
    private optionsrepository optionsrepository;
    public Iterable<options> getAllOptions() {
        return optionsrepository.findAll();
    }
    public options createOption(options o) {
        if (optionsrepository.findByOptionName(o.getOptionName()) != null) {
            return null;
        }
        return optionsrepository.save(o);
    }
    public options getOptionById(Long id) {
        return optionsrepository.findById(id).orElse(null);
    }
}
