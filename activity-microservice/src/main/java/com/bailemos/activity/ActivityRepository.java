package com.bailemos.activity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

  List<Activity> findAllByEventId(Long eventId);
}
