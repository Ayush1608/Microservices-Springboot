package com.self.movieinfoservice.resources;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieResource {

  @RequestMapping("/{movieId}")
  public Movie getMovie(@PathVariable String movieId) {
    return new Movie(movieId, "John Wick");
  }
}
