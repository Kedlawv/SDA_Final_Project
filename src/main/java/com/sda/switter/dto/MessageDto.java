package com.sda.switter.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageDto {

    @NotNull
    @Size(min = 1, max = 160, message = "Message must be between 1 - 160 characters long")
    @Column(name="message_text")
    private String messageText;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
