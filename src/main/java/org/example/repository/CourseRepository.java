package org.example.repository;

import java.util.Optional;
import org.example.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

  Optional<Course> findFirstByOrderByIdDesc();
}
