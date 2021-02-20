package com.self.currencyexchangeservice.controller;


import java.math.BigDecimal;

import com.self.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

  @Autowired
  Environment environment;

  @GetMapping("/currency-exchange/{from}/USD/{to}/INR")
  public CurrencyExchange retrieveExchangeValue(
    @PathVariable String from,
    @PathVariable String to
  ) {
      return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(70), environment.getProperty("local.server.port"));
  }
}
