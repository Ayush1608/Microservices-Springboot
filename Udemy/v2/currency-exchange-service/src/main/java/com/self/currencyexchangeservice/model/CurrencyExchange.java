package com.self.currencyexchangeservice.model;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CurrencyExchange {

  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;

  // Below variable is just for checking from which instance response is received
  private String environment;
}
