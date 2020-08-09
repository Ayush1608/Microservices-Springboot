package com.self.moviecatalogservice.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Rating {
  private String movieId;
  private int rating;

  public Rating() {}

  public Rating(final String movieId, final int rating) {
    this.movieId = movieId;
    this.rating = rating;
  }
}
