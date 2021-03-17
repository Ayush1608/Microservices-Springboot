package com.self.currencyconversionservice;


import com.self.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(value = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(value = "currency-exchange-service") //Just removing the URL and introducing Eureka naming server enables the load balancing for free
@FeignClient(name = "currency-exchange-service", url = "${CURRENCY_EXCHANGE_SERVICE_SERVICE_HOST:http://localhost}:8000") //
// CURRENCY_EXCHANGE_SERVICE_HOST is
// env
// variable we need to setup in K8S
public interface CurrencyExchangeProxy {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
