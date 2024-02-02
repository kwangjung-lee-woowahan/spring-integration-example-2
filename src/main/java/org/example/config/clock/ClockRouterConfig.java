package org.example.config.clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;

@Configuration
public class ClockRouterConfig {

  private final ClockRouter clockRouter;

  public ClockRouterConfig(ClockRouter clockRouter) {
    this.clockRouter = clockRouter;
  }

  @Bean
  public IntegrationFlow route() {
    return IntegrationFlow.from("ServiceGateway")
        .route(clockRouter)
        .get();
  }
}
