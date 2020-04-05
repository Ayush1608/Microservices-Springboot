package com.self.springbootconfig.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties("sample")
@Getter
@Setter
public class SampleConfig {
  private String name;
  private int age;
}
