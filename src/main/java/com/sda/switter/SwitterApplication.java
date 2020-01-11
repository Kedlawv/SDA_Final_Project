package com.sda.switter;

import com.sda.switter.model.User;
import com.sda.switter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SwitterApplication implements ApplicationRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SwitterApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addUser(new User("waldek@waldek.pl", "Waldek", passwordEncoder.encode("12345")));
    }
}
