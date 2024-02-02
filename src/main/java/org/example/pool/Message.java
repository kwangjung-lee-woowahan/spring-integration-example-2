package org.example.pool;

import lombok.Getter;

@Getter
public class Message {

  private final String target;
  private final Object payload;

  public Message(String target, Object payload) {
    this.target = target;
    this.payload = payload;
  }
}
