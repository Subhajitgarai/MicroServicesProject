package com.lcwd.user.service.service;

import com.lcwd.user.service.enteties.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    //For Saving single user
    public User saveUser(User user);
    //Getting the user details all
    public List<User> getUser();
    //Getting the single user details the hotel and rating microservices also called here to set data in the List
    public User getUseById(String userId);
}
