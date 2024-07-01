package com.lcwd.user.service.service;

import com.lcwd.user.service.Dao.UserRepo;
import com.lcwd.user.service.enteties.Hotel;
import com.lcwd.user.service.enteties.Ratings;
import com.lcwd.user.service.enteties.User;
import com.lcwd.user.service.external.services.HotelExternalService;
import com.lcwd.user.service.external.services.RatingsExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HotelExternalService hotelExternalService;
    @Autowired
    RatingsExternalService ratingsExternalService;

    //Creating Logger to print in the console
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    public User saveUser(User user){
       return userRepo.save(user);
    }
    public List<User> getUser(){

        return userRepo.findAll();
    }

    public User getUseById(String userId){
        User user=userRepo.findById(userId).orElse(null);
//        //For Api Calling
//        //Getting the Rating of user by api calling and setting that
//        String url = "http://RATING-SERVICE/ratings/user/" + userId;
//        Ratings[] ratings = restTemplate.getForObject(url, Ratings[].class);
//        logger.info("{}", ratings);
//        List<Ratings> ratingsOfUser = Arrays.stream(ratings).toList();

//        Getting Rattings by using Feign Client
        List<Ratings>ratingsOfUser=ratingsExternalService.getRatingsByUserId(userId)
        // You can call the following external api by WebClient also
//        WebClient webClient=WebClient.create();
//        List<Ratings> userRatings = webClient.get().uri("http://localhost:8082/ratings/user/" + userId)
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<Ratings>>() {
//                })
//                .onErrorMap((e) -> new RuntimeException("Error while calling api ", e))
//                .block();
//        userRatings.forEach(ratings -> {
//            System.out.println("UserId = "+ratings.getUserId());
//        });


        //Getting Hotel information and set that in the Rating List
        ratingsOfUser.forEach(rat->{
            String hotelId=rat.getHotelId();
            //Calling api to get Hotel by HotelId and By RestTemplate
//            String url1 = "http://HOTEL-SERVICE/hotels/" + hotelId;
//            ResponseEntity<Hotel> forEntity= restTemplate.getForEntity(url1, Hotel.class);
//            Hotel hotel=forEntity.getBody();
//            rat.setHotel(hotel);

            //Calling Api By Feign Client of Hotel
            Hotel hotel=hotelExternalService.getHotel(hotelId);
            rat.setHotel(hotel);
        });
        user.setRating(ratingsOfUser);
        return user;

    }
}
