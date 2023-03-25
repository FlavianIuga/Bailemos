package com.bailemos.attendance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

  public List<Attendance> findByActivityId(Long activityId);
}
