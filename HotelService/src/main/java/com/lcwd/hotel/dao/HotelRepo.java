package com.lcwd.hotel.dao;

import com.lcwd.hotel.enteties.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
