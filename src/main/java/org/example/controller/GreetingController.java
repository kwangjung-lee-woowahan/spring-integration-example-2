package org.example.controller;

import org.example.service.ServiceGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private final ServiceGateway gateway;

  public GreetingController(ServiceGateway gateway) {
    this.gateway = gateway;
  }

  @GetMapping("/greeting")
  public String greeting(@RequestParam(defaultValue = "Java") String name) {
    return gateway.request(name);
  }
}
