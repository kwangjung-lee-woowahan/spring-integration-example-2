package org.example.pool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class EchoBlock extends PoolBlock {

  private final PoolGateway gateway;

  public EchoBlock(PoolGateway gateway) {
    this.gateway = gateway;
  }

  @ServiceActivator(inputChannel = "Echo")
  public Object handle(Message message) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(message.getPayload());
  }
}
