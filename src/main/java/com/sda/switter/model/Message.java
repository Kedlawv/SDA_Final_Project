package com.sda.switter.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Message {

    public Message(@Size(min = 1, max = 160) String messageText) {
        this.dateOfCreation = LocalDateTime.now();
        this.messageText = messageText;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="date_of_creation")
    private LocalDateTime dateOfCreation;
    @Size(min = 1, max = 160)
    @Column(name="message_text")
    private String messageText;


    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
