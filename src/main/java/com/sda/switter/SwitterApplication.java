package com.sda.switter;

import com.sda.switter.model.User;
import com.sda.switter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import com.sda.switter.model.Message;
import com.sda.switter.services.MessagesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SwitterApplication implements ApplicationRunner {

    @Autowired
    MessagesService ms;

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
        userService.addUser(new User("marek@marek.pl", "Marek", passwordEncoder.encode("12345")));
        userService.addUser(new User("bozena@bozena.pl", "Bozena", passwordEncoder.encode("12345")));



        Message m1 = new Message("Beware of the Dark Side of the Force",
                userService.getUserByUserName("Waldek"));
        Message m2 = new Message("Sugar makes you sleepy",
                userService.getUserByUserName("Waldek"));
        Message m3 = new Message("Failures are simply stepping stones to success",
                userService.getUserByUserName("Waldek"));
        ms.addMessage(m1);
        ms.addMessage(m2);
        ms.addMessage(m3);
    }
}
