package com.self.currencyconversionservice.model;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionBean {
  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionFactor;
  private BigDecimal quantity;
  private BigDecimal totalCalculatedAmount;
  private int port;
}
