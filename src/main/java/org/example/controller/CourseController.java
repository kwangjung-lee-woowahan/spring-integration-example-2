package org.example.controller;

import java.util.List;
import org.example.controller.requests.CreateCourseRequest;
import org.example.service.CourseService;
import org.example.service.ServiceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @PostMapping("/create-course")
  public Long createCourse(@RequestBody CreateCourseRequest request) {
    return courseService.create(request.getSequence());
  }

  @GetMapping("/get-course")
  public List<ServiceType> getCourse() {
    return courseService.last();
  }
}
