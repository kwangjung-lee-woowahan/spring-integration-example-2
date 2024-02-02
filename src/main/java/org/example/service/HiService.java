package org.example.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class HiService {

  @ServiceActivator(inputChannel = "HiChannel")
  public String handle(String name) {
    return "Hi " + name + "!";
  }
}
