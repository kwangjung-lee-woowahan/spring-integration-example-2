package org.example.config.clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ClockChannelConfig {


  @Bean(name = "HiChannel")
  public MessageChannel hiChannel() {
    return new DirectChannel();
  }

  @Bean(name = "HelloChannel")
  public MessageChannel helloChannel() {
    return new DirectChannel();
  }
}
