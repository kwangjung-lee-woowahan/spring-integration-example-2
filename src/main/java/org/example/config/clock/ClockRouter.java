package org.example.config.clock;

import java.util.Collection;
import java.util.List;
import org.example.domain.Clock;
import org.example.service.ClockService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class ClockRouter extends AbstractMessageRouter {

  private final ClockService clockService;
  private final MessageChannel hiChannel;
  private final MessageChannel helloChannel;

  public ClockRouter(ClockService clockService, @Qualifier("HiChannel") MessageChannel hiChannel,
      @Qualifier("HelloChannel") MessageChannel helloChannel) {
    this.clockService = clockService;
    this.hiChannel = hiChannel;
    this.helloChannel = helloChannel;
  }

  @Override
  protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
    Clock clock = clockService.get();
    if (clock.getNum() % 2 == 0) {
      return List.of(hiChannel);
    } else {
      return List.of(helloChannel);
    }
  }
}
