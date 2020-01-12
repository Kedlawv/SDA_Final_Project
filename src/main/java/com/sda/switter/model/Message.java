package com.sda.switter.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="messages")
public class Message {

    public Message() {
    }

    public Message(@Size(min = 1, max = 160) String messageText, User user) {
        this.dateOfCreation = LocalDateTime.now();
        this.messageText = messageText;
        this.owner = user;
        this.repliedTo = -1;
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

    @OneToMany
    private Set<Message> replies;

    private long repliedTo;

    public void setReplies(Set<Message> replies) {
        this.replies = replies;
    }

    public long getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(long repliedTo) {
        this.repliedTo = repliedTo;
    }

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

    public void addReply(Message reply) {
        this.replies.add(reply);
    }

    public Set<Message> getReplies() {
        return replies;
    }
}





