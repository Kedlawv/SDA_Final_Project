package com.sda.switter.services;

import com.sda.switter.dao.MessageRepository;
import com.sda.switter.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {

    @Autowired
    private MessageRepository repository;

    public void addMessage(Message message){
        repository.save(message);
    }
}
