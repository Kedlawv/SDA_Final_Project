package com.sda.switter.services;

import com.sda.switter.dao.MessageRepository;
import com.sda.switter.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessagesService {

    @Autowired
    private MessageRepository repository;

    public void addMessage(Message message){
        message.setDateOfCreation(LocalDateTime.now());
        repository.save(message);
    }

    public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
}
