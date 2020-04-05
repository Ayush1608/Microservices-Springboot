package com.self.moviecatalogservice.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Movie {
  private String movieId;
  private String name;

  public Movie() { }
  public Movie(final String movieId, final String name) {
    this.movieId = movieId;
    this.name = name;
  }
}
