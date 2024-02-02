package org.example.infra;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.service.ServiceType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseHandler {

  private static final ThreadLocal<List<ServiceType>> courseThreadLocal =
      ThreadLocal.withInitial(ArrayList::new);
  private static final ThreadLocal<Integer> counterThreadLocal =
      ThreadLocal.withInitial(() -> 0);

  public static void registerCourse(List<ServiceType> newCourse) {
    courseThreadLocal.set(newCourse);
  }

  public static List<ServiceType> getCourse() {
    return courseThreadLocal.get();
  }

  public static Integer getCounter() {
    return counterThreadLocal.get();
  }

  public static void increaseCounter() {
    Integer counter = counterThreadLocal.get();
    counterThreadLocal.set(counter + 1);
  }

  public static void clear() {
    courseThreadLocal.get().clear();
    counterThreadLocal.set(0);
  }
}
