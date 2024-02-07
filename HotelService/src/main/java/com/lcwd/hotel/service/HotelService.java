package com.lcwd.hotel.service;

import com.lcwd.hotel.enteties.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    //To Create a Single Hotel
    public Hotel createHotel(Hotel hotel);
    //To get AllHotel Details
    public List<Hotel> getAllHotel();
    //To get Single Hotel details
    public Optional<Hotel> getSingleHotel(String id);
}
