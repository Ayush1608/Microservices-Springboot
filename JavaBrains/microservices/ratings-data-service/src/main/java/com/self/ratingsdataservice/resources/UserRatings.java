package com.self.ratingsdataservice.resources;


import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRatings {
  private List<Rating> ratings;

  public String userId;
  public UserRatings() {}

}
