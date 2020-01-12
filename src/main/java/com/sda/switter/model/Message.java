package com.sda.switter.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Message {

    public Message() {
    }

    public Message(@Size(min = 1, max = 160) String messageText, User user) {
        this.dateOfCreation = LocalDateTime.now();
        this.messageText = messageText;
        this.owner = user;
    }

    public Message(@NotNull LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="date_of_creation")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateOfCreation;

    @NotNull
    @Size(min = 1, max = 160, message = "Message must be between 1 - 160 characters long")
    @Column(name="message_text")
    private String messageText;

    @NotNull
    @ManyToOne
    private User owner;

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

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





