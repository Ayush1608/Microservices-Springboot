package com.self.moviecatalogservice.model;


import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRatings {
  private String userId;
  private List<Rating> ratings;

  public UserRatings() {}

  public UserRatings(final String userId, final List<Rating> ratings) {
    this.userId = userId;
    this.ratings = ratings;
  }
}
