package com.sda.switter.services;

import com.sda.switter.dao.UserRepository;
import com.sda.switter.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;



public class UserService {

    @Autowired
    public UserRepository repository;

    public List<User> getAll(){
        return (List<User>)repository.findAll();
    }
}
