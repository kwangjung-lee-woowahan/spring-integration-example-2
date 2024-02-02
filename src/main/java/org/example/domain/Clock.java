package org.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "counter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long num;

  public Clock(Long id, Long num) {
    this.id = id;
    this.num = num;
  }

  public static Clock newOne() {
    return new Clock(null, 0L);
  }

  public void toggle() {
    this.num = (this.num + 1) % 2;
  }
}
