package com.bailemos.attendance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

  List<Attendance> findByActivityId(Long activityId);

  List<Attendance> findByActivityIdIn(List<Long> activityId);

  List<Attendance> findByUserIdAndActivityIdIn(Long userId, List<Long> activityIds);
}
