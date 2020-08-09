package com.self.moviecatalogservice.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.self.moviecatalogservice.model.Movie;
import com.self.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieInfoService {

  @Autowired
  private RestTemplate restTemplate;

  //Implementing Bulk head pattern in hystrix
  @HystrixCommand(
    fallbackMethod = "getFallbackMovieInfo",
    threadPoolKey = "movieInfoPool", //creating a seperate thread pool
    threadPoolProperties = {
      @HystrixProperty(name = "coreSize", value = "20"), // 20 executes simultaneously
      @HystrixProperty(name = "maxQueueSize", value = "10") // 10 waits in queue w/o execution
    }
                  )
  public Movie getMovieInfo(final Rating rating) {
    return restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), Movie.class);
  }

  private Movie getFallbackMovieInfo(final Rating rating) {
    return new Movie("000", "No Movie");
  }
}
