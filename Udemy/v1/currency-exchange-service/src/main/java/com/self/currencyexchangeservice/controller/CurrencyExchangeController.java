package com.self.currencyexchangeservice.controller;


import java.util.Objects;

import com.self.currencyexchangeservice.model.ExchangeValue;
import com.self.currencyexchangeservice.repostory.ExchangeValueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeValueRepository exchangeValueRepository;

  @GetMapping("currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                             @PathVariable String to) {
    ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
    exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
    log.info("{}", exchangeValue);
    return exchangeValue;
  }
}
