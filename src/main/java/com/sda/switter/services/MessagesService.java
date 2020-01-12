package com.sda.switter.services;

import com.sda.switter.dao.MessageRepository;
import com.sda.switter.dao.UserRepository;
import com.sda.switter.dto.MessageDto;
import com.sda.switter.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    @Autowired
    private MessageRepository messageRepo;
    @Autowired
    private UserRepository userRepo;

    public void addMessage(MessageDto messageDto, String username){
        Message message = new Message();
        message.setDateOfCreation(LocalDateTime.now());
        message.setMessageText(messageDto.getMessageText());
        message.setOwner(userRepo.getUserByUsername(username));

        messageRepo.save(message);
    }

    public void addMessage(Message message){
        message.setDateOfCreation(LocalDateTime.now());
        message.setMessageText(message.getMessageText());

        messageRepo.save(message);
    }

    public List<Message> getAll(){
        return (List<Message>) messageRepo.findAll();
    }

    public Message findById(Long id) {
        Optional<Message> result = messageRepo.findById(id);

        Message message = null;

        if (result.isPresent()) {
            message = result.get();
        } else {
            throw new RuntimeException("Message not found: id " + id);
        }

        return message;
    }

    @Transactional
    public void addReply(Message message, Message reply){

        Optional optMessage = messageRepo.findById(message.getId());
        Message currentMessage = new Message();
        if(optMessage.isPresent()){
            currentMessage = (Message)optMessage.get();
        }
        reply.setRepliedTo(currentMessage.getId());
        reply = messageRepo.save(reply);
        currentMessage.addReply(reply);


        messageRepo.save(message);
    }

}
