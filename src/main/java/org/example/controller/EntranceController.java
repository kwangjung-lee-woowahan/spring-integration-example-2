package org.example.controller;

import org.example.controller.requests.MainRequest;
import org.example.pool.Message;
import org.example.pool.PoolGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntranceController {

  private final PoolGateway gateway;

  public EntranceController(PoolGateway gateway) {
    this.gateway = gateway;
  }

  @PostMapping("/entrance")
  public String entrance(@RequestBody MainRequest request) {
    return gateway.request(new Message(request.getTarget(), request.getPayload()));
  }
}
