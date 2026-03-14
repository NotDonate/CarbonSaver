package com.example.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.options;
import com.example.demo.Services.OptionsService;

@RestController
@RequestMapping("/options")
public class OptionsController {
    @Autowired
    private OptionsService optionsService;
    @GetMapping
    public Iterable<options> getAllOptions() {
        return optionsService.getAllOptions();
    }
    @PostMapping
    public options createOption(@RequestBody options o) {
        return optionsService.createOption(o);
    }
    @GetMapping("/{id}")
    public options getOptionById(@PathVariable Long id) {
        return optionsService.getOptionById(id); 
    }
}