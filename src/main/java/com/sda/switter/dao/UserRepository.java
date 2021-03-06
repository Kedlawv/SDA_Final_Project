package com.sda.switter.dao;

import com.sda.switter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User getUserByUsername(String userName);
}
