package org.example.controller;

import org.example.service.ClockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockController {

  private final ClockService clockService;

  public ClockController(ClockService clockService) {
    this.clockService = clockService;
  }

  @PostMapping("/create-counter")
  public Long createCounter() {
    return clockService.create();
  }
}
