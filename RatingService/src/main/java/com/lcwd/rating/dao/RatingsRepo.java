package com.lcwd.rating.dao;

import com.lcwd.rating.entites.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingsRepo extends JpaRepository<Ratings,String> {
    List<Ratings>findByUserId(String userId);
    List<Ratings>findByHotelId(String hotelId);
}
