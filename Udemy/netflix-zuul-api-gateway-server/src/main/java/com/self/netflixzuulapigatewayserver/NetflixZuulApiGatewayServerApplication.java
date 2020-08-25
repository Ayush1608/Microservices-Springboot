package com.self.netflixzuulapigatewayserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayServerApplication {

  // Note: For request to intercept through it, the port in request should be zuul followed by application name for which we
  // want to execute API. Example: http://localhost:8000/currency-exchange/from/USD/to/INR will be written as
  // http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR.
  // Also, Please check feign client for currency-converter-service


  public static void main(String[] args) {
    SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
  }

}
