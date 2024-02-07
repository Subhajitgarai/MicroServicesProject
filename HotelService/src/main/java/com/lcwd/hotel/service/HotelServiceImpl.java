package com.lcwd.hotel.service;

import com.lcwd.hotel.dao.HotelRepo;
import com.lcwd.hotel.enteties.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepo hotelRepo;
    public Hotel createHotel(Hotel hotel){
       return hotelRepo.save(hotel);
    }
    public List<Hotel> getAllHotel(){
       return hotelRepo.findAll();
    }
    public Optional<Hotel> getSingleHotel(String id){
       return hotelRepo.findById(id);
    }
}
