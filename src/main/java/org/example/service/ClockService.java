package org.example.service;

import org.example.repository.ClockRepository;
import org.example.domain.Clock;
import org.springframework.stereotype.Service;

@Service
public class ClockService {

  private final ClockRepository clockRepository;

  public ClockService(ClockRepository clockRepository) {
    this.clockRepository = clockRepository;
  }

  public Long create() {
    Clock clock = Clock.newOne();
    Clock saved = clockRepository.save(clock);
    return saved.getId();
  }

  public Clock get() {
    Clock clock = clockRepository.getReferenceById(1L);
    clock.toggle();
    return clockRepository.save(clock);
  }
}
