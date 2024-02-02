package org.example.pool;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class MultiplyTwoBlock extends PoolBlock {

  private final PoolGateway gateway;

  public MultiplyTwoBlock(PoolGateway gateway) {
    this.gateway = gateway;
  }

  @ServiceActivator(inputChannel = "MultiplyTwo")
  public Object handle(Message message) throws JsonProcessingException {
    Integer targetValue = getValue(message.getTarget(), message.getPayload());

    Integer newTargetValue = targetValue * 2;

    Object payload = newPayload(newTargetValue, message.getTarget(), message.getPayload());

    Message newMessage = new Message(message.getTarget(), payload);
    return gateway.request(newMessage);
  }
}
