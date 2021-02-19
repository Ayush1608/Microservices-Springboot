package com.self.currencyexchangeservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeValue {
  @Id
  private Long id;
  @Column(name = "currency_from")
  private String from;
  @Column(name = "currency_to")
  private String to;
  private BigDecimal conversionFactor;
  private int port;
}
