package com.self.springbootconfig.controller;


import java.util.List;
import java.util.Map;

import com.self.springbootconfig.config.SampleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")
@RefreshScope //refreshes the properties used and fetch their latest value from config server. annotation is from actuator
// we need to make a post request to <server>:<this port>/actuator/refresh
public class GreetingController {

  @Autowired
  private SampleConfig sampleConfig;

  @Autowired
  private Environment environment;

  @Value("${message: default value}")
  private String message;

  @Value("${list.messages}")
  private List<String> messageList;

  @Value("#{${map.messages}}") //using spel -> spring expression language, can also be used to get values of other beans
  private Map<String, String> messageMap;

  @GetMapping("/message")
  public String getMessage() {
    return message;
  }

  @GetMapping("/messageList")
  public List<String> getMessageList() {
    return messageList;
  }

  @GetMapping("/messageMap")
  public Map<String, String> getMessageMap() {
    return messageMap;
  }

  @GetMapping("/sampleConfig")
  public String getSampleMessage() {
    return sampleConfig.getName() + sampleConfig.getAge();
  }

  @GetMapping("/env")
  public String getEnvDetails() {
    return environment.toString();
  }


  @Value("Test")
  public void printValues1(String s, String v){} //both 's' and 'v' values will be 'Test'

  @Value("Test")
  public void printValues2(String s, @Value("Data") String v){} // s=Test, v=Data
}
