package org.example.config.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;

@Configuration
public class PoolRouterConfig {

  private final PoolRouter poolRouter;

  public PoolRouterConfig(PoolRouter poolRouter) {
    this.poolRouter = poolRouter;
  }

  @Bean
  public IntegrationFlow poolRoute() {
    return IntegrationFlow.from("PoolGateway")
        .route(poolRouter)
        .get();
  }
}
