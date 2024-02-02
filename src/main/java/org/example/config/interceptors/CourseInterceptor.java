package org.example.config.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.example.infra.CourseHandler;
import org.example.service.CourseService;
import org.example.service.ServiceType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CourseInterceptor implements HandlerInterceptor {

  private final CourseService courseService;

  public CourseInterceptor(CourseService courseService) {
    this.courseService = courseService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("==== Interceptor preHandle =====");
    List<ServiceType> course = courseService.last();
    CourseHandler.registerCourse(course);
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("==== Interceptor postHandle =====");
    CourseHandler.clear();
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }
}
