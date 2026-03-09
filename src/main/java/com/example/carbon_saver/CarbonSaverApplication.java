package com.example.carbon_saver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.carbon_saver.entity.Options;
import com.example.carbon_saver.entity.UserChoiceHistory;
import com.example.carbon_saver.entity.UserInformation;
import com.example.carbon_saver.entity.Users;

import com.example.carbon_saver.repository.OptionsRepository;
import com.example.carbon_saver.repository.UserChoiceHistoryRepository;
import com.example.carbon_saver.repository.UserInformationRepository;
import com.example.carbon_saver.repository.UsersRepository;

@EnableJpaAuditing
@SpringBootApplication
public class CarbonSaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbonSaverApplication.class, args);
    }

    @Bean
public CommandLineRunner commandLineRunner(
        ApplicationContext ctx,
        UsersRepository usersRepository,
        OptionsRepository optionsRepository,
        UserInformationRepository userInformationRepository,
        UserChoiceHistoryRepository userChoiceHistoryRepository) {
    return args -> {

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Users user = new Users();
        user.setName("Alice");
        user.setEmail("alice@email.com");
        user.setPassword("pass123");
        user.setUserType("student");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        usersRepository.save(user);

        Options option = new Options();
        option.setOptionName("Option A");
        optionsRepository.save(option);

        UserInformation info = new UserInformation();
        info.setUser(user);
        info.setUserClass(2);
        info.setBudget(1200);
        info.setRent(true);
        info.setInformationAtDate(LocalDate.now());
        userInformationRepository.save(info);

        UserChoiceHistory history = new UserChoiceHistory();
        history.setUser(user);
        history.setOption(option);
        history.setUserInformation(info);
        history.setDatePicked(LocalDate.now());
        history.setScore(85);
        userChoiceHistoryRepository.save(history);
    };
}
}