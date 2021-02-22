package com.self.currencyconversionservice.controller;


import java.math.BigDecimal;

import com.self.currencyconversionservice.controller.model.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyConversionController {

  @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion calculateCurrencyConversion(
    @PathVariable String from,
    @PathVariable String to,
    @PathVariable BigDecimal quantity
  ) {
      return CurrencyConversion.builder()
                               .id(1L)
                               .from(from)
                               .to(to)
                               .quantity(quantity)
                               .conversionMultiple(BigDecimal.ONE)
                               .totalCalculatedAmount(BigDecimal.ONE)
                               .build();
  }
}
