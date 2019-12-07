package com.sda.switter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private LocalDateTime dateOfCreation;
    @Size(min = 1, max = 160)
    private String messageText;
}
