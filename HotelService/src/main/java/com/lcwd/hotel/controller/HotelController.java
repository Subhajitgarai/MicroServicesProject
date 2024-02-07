package com.lcwd.hotel.controller;

import com.lcwd.hotel.enteties.Hotel;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;
    //Create a Hotel
    @PostMapping
    public Hotel addHotels(@RequestBody Hotel hotel){
        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
       return hotelService.createHotel(hotel);
    }
    //GetallHotels
    @GetMapping
    public List<Hotel> getHotels(){
       return hotelService.getAllHotel();
    }
    //Get Single Hotel
    @GetMapping("/{id}")
    public Optional<Hotel> SingleHotel(@PathVariable String id){
       return hotelService.getSingleHotel(id);
    }
}
