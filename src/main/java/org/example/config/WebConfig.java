package org.example.config;

import org.example.config.interceptors.CourseInterceptor;
import org.example.service.CourseService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final CourseService courseService;

  public WebConfig(CourseService courseService) {
    this.courseService = courseService;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new CourseInterceptor(courseService))
        .addPathPatterns("/entrance");
  }
}
