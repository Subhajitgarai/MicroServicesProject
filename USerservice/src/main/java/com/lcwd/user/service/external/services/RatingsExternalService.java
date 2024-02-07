package com.lcwd.user.service.external.services;

import com.lcwd.user.service.enteties.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingsExternalService {
    //Calling the ratings api for getting ratings details from userId
    @GetMapping("/ratings/user/{userId}")
    List<Ratings> getRatingsByUserId(@PathVariable String userId);
}
