package com.self.currencyexchangeservice.controller;


import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class CircuitBreakerController {

  @GetMapping("/currency-exchange/sample-api")
//  @Retry(name = "default") By default 3 retries happen.
  @Retry(name = "sample-api", fallbackMethod = "fallbackSampleAPI")
  public String sampleAPI() {
    log.info("Request for Sample API received!");
    return new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class).getBody();
  }


  /**
   * This fallback method should always be public. Also, argument for Exception is needed else it throws UndeclaredThrowableException.
   * This Exception is same for what main API method throws, so we can have multiple fallback methods for a single API as per what exception it can
   * throw.
   * @param ex
   * @return string
   */
  public String fallbackSampleAPI(Exception ex) {
    return "Fallback Sample String";
  }
}
