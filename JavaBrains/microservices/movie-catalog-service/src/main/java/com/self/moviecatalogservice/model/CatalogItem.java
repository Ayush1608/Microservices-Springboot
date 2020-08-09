package com.self.moviecatalogservice.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CatalogItem {
  private String name;
  private String desc;
  private int rating;

  public CatalogItem() {}

  public CatalogItem(final String name, final String desc, final int rating) {
    this.name = name;
    this.desc = desc;
    this.rating = rating;
  }
}
