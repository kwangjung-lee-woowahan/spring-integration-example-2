package org.example.repository;

import org.example.domain.Clock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClockRepository extends JpaRepository<Clock, Long> {

}
