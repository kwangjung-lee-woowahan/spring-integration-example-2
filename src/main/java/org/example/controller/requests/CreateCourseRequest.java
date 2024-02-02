package org.example.controller.requests;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.service.ServiceType;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateCourseRequest {

  private List<ServiceType> sequence;
}
