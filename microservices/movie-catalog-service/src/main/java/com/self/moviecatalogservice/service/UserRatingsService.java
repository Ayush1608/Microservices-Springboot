package com.self.moviecatalogservice.service;


import java.util.Arrays;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.self.moviecatalogservice.model.Rating;
import com.self.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class UserRatingsService {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "getFallbackUserRatings")
  public UserRatings getUserRatings(@PathVariable("userId") final String userId) {
    return restTemplate.getForObject("http://rating-data-service/ratingsdata/user-ratings/" + userId,
                                     UserRatings.class);
  }

  private UserRatings getFallbackUserRatings(@PathVariable("userId") final String userId) {
    return new UserRatings(userId, Arrays.asList(new Rating("000", 0)));
  }
}
