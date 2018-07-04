package com.training.backend.configuration;

import com.training.backend.domain.User;
import com.training.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("Donald","Trump",65));
        userRepository.save(new User("Justin","Trudor",48));
    }
}
