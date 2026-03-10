package com.example.demo.Repos;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.options;

public interface optionsrepository extends CrudRepository<options, Long> {
    options findByOptionName(String optionName);
    
}
