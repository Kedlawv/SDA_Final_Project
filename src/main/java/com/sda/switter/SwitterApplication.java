package com.sda.switter;

import com.sda.switter.model.Message;
import com.sda.switter.services.MessagesService;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwitterApplication implements ApplicationRunner{

    @Autowired
    MessagesService ms;

    public static void main(String[] args) {
        SpringApplication.run(SwitterApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Message m1 = new Message("Beware of the Dark Side of the Force");
        Message m2 = new Message("Sugar makes you sleepy");
        Message m3 = new Message("Failures are are simply stepping stones to success");
        ms.addMessage(m1);
        ms.addMessage(m2);
        ms.addMessage(m3);
    }
}
