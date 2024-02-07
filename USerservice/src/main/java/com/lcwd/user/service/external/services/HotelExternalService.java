package com.lcwd.user.service.external.services;

import com.lcwd.user.service.enteties.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//For Feign client api calling
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelExternalService {
    //Calling the Hotel Api by Hotel id
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
