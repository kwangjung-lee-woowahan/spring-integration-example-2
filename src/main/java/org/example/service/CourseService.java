package org.example.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.example.domain.Course;
import org.example.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Long create(List<ServiceType> sequence) {
    Course course = new Course(null, sequence);
    Course saved = courseRepository.save(course);
    return saved.getId();
  }

  public List<ServiceType> last() {
    Optional<Course> courseOptional = courseRepository.findFirstByOrderByIdDesc();
    if (courseOptional.isPresent()) {
      return courseOptional.get().getSequence();
    } else {
      return Collections.emptyList();
    }
  }
}
