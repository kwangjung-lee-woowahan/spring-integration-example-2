package org.example.controller.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MainRequest {

  private String target;
  private Object payload;
}
