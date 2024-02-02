package org.example.config.pool;

import java.util.Collection;
import java.util.List;
import org.example.infra.CourseHandler;
import org.example.service.ServiceType;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class PoolRouter extends AbstractMessageRouter {

  private final ApplicationContext context;

  public PoolRouter(ApplicationContext context) {
    this.context = context;
  }

  @Override
  protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
    List<ServiceType> course = CourseHandler.getCourse();
    Integer counter = CourseHandler.getCounter();

    if (course.size() == counter) {
      return List.of((MessageChannel) context.getBean("Echo"));
    }

    ServiceType current = course.get(counter);
    CourseHandler.increaseCounter();

    return List.of((MessageChannel) context.getBean(current.name()));
  }
}
