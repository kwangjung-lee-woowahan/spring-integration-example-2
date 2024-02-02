package org.example.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @ServiceActivator(inputChannel = "HelloChannel")
  public String handle(String name) {
    return "Hello " + name + "!";
  }
}
