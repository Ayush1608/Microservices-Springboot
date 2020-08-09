package com.self.moviecatalogservice.resources;



import java.util.List;
import java.util.stream.Collectors;
import com.self.moviecatalogservice.model.CatalogItem;
import com.self.moviecatalogservice.model.Movie;
import com.self.moviecatalogservice.model.UserRatings;
import com.self.moviecatalogservice.service.MovieInfoService;
import com.self.moviecatalogservice.service.UserRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  MovieInfoService movieInfoService;

  @Autowired
  UserRatingsService userRatingsService;

//  @Autowired
//  private WebClient.Builder webClientBuilder; //Used for asynchronous programming

  /*
      Using rest template
   */
  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

    UserRatings ratings = userRatingsService.getUserRatings(userId);
    return ratings.getRatings().stream().map(rating -> {
      Movie movie = movieInfoService.getMovieInfo(rating);
      return new CatalogItem(movie.getName(), "Action", rating.getRating());
    }).collect(Collectors.toList());
  }


  /*
      Using web client
   */
//  @RequestMapping("/{userId}")
//  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//
//    List<Rating> ratings = Arrays.asList(
//      new Rating("1234", 4),
//      new Rating("5678", 3)
//    );
//    return ratings.stream().map(rating -> {
//      Movie movie = webClientBuilder.build()
//                                    .get()
//                                    .uri("http://localhost:8081/movie/" + rating.getMovieId())
//                                    .retrieve()
//                                    .bodyToMono(Movie.class)// Mono is kind of a promise that you are going to get this type of object back
//                                    .block(); //blocking execution till mono is received.
//      return new CatalogItem(movie.getName(), "Action", rating.getRating());
//    }).collect(Collectors.toList());
//  }
}
