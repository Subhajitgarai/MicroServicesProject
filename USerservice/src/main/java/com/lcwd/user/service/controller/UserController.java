package com.lcwd.user.service.controller;

import com.lcwd.user.service.enteties.User;
import com.lcwd.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    private Logger logger= LoggerFactory.getLogger(UserController.class);
    //Add a user
    @PostMapping
    public User addUser(@RequestBody User user){
        String randomuserId= UUID.randomUUID().toString();
        user.setUserId(randomuserId);
       return userService.saveUser(user);
    }
    //Get all userDetails
    @GetMapping
    public List<User> getAlluser(){
        return userService.getUser();
    }
    //For getting Single userdetails and implemented retry module and setted the max attempt in properties if the max attempt exceeds then the fallback methode is called.
    int retryCount=0;
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @GetMapping("/{userId}")
    public User getSingleUserDetail(@PathVariable String userId){
        logger.info("Retry Count: {}",retryCount);
        retryCount++;
        return userService.getUseById(userId);
    }

    //Creating fallback methode for circuit breaker and Retry module
    public User ratingHotelFallback(String userId,Exception ex){
        logger.info("Sorry Some servioces are down !!",ex.getMessage());
        //Creatig a dummy user when service is down then the dummy will be loaded up front
        User user=new User();
        user.setUserId("dummy123");
        user.setEmail("dummy@gmail.com");
        user.setName("dummy");
        user.setAbout("This is a demo user created because some services are down");
        return user;

    }
}
