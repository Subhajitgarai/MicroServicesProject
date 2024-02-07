package com.lcwd.rating.services;

import com.lcwd.rating.dao.RatingsRepo;
import com.lcwd.rating.entites.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingServiceImpl implements RatingsService{
    @Autowired
    RatingsRepo ratingsRepo;
    //Create a new Rating
    public Ratings addRatings(Ratings ratings){
       return ratingsRepo.save(ratings);
    }
    //Get all Ratings
    public List<Ratings> getAllRatings(){
       return ratingsRepo.findAll();

    }
    //getallby UserId
    public List<Ratings> getAllByUserId(String userId){
      return ratingsRepo.findByUserId(userId);
    }
    //Get all by HotelId
    public List<Ratings> getAllByHotelId(String hotelId){
       return ratingsRepo.findByHotelId(hotelId);

    }
}
