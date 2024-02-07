package com.lcwd.rating.controller;

import com.lcwd.rating.entites.Ratings;
import com.lcwd.rating.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingsController {
    @Autowired
    RatingsService ratingsService;
    //To Add Ratings details
    @PostMapping
    public Ratings addRatings(@RequestBody Ratings ratings){
        String ratingId= UUID.randomUUID().toString();
        ratings.setRatingsId(ratingId);
       return ratingsService.addRatings(ratings);
    }
    //To get all the registered ratings details
    @GetMapping
    public List<Ratings> getAllRatings(){
        return ratingsService.getAllRatings();
    }
    //To get the ratings details by UserId
    @GetMapping("/user/{userId}")
    public List<Ratings> getRatingsByUSerId(@PathVariable String userId){
       return ratingsService.getAllByUserId(userId);

    }
    //To get all the rating details by hotelId
    @GetMapping("/hotel/{hotelId}")
    public List<Ratings> getRatingsByHotelId(@PathVariable String hotelId){
       return ratingsService.getAllByHotelId(hotelId);

    }

}
