package com.self.currencyconversionservice.service;


import com.self.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "currency-exchange-service" /*, url = "localhost:8000"*/) //After adding Ribbon we do not add url here
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service") // client side load balancing
public interface CurrencyExchangeServiceProxy {

//  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
  CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
