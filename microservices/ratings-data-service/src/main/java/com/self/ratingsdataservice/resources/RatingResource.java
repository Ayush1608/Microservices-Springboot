package com.self.ratingsdataservice.resources;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

  @RequestMapping("/rating/{movieId}")
  public Rating getRating(@PathVariable("movieId") String movieId) {
    return new Rating(movieId, 4);
  }

  @RequestMapping("/user-ratings/{userId}")
  public UserRatings getRatingList(@PathVariable("userId") String userId) {
    /*IMPORTANT - Avoid using returning lists, try and return object. the consumer may always go for
        list. But if we somehow convert this api to return object at a certain point of time, their code/API will fail.
        eg - if we add users name with list of ratings we have to convert it in a object.
    */
//    return Arrays.asList(
//      new Rating("1234", 4),
//      new Rating("5678", 3)
//    );

    UserRatings ratings = new UserRatings();
    ratings.setUserId(userId);
    ratings.setRatings(Arrays.asList(
      new Rating("1234", 4),
      new Rating("5678", 3)
    ));
    return ratings;

  }
}
