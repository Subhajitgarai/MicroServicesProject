package com.lcwd.rating.services;

import com.lcwd.rating.entites.Ratings;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RatingsService {
    //Add a new Rating
    public Ratings addRatings(Ratings ratings);
    //Get all Ratings
    public List<Ratings> getAllRatings();
    //Get all Ratings by userId
    public List<Ratings> getAllByUserId(String userId);
    //Get all ratings by UserId
    public List<Ratings> getAllByHotelId(String hotelId);
}
