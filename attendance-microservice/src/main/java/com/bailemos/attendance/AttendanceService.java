package com.bailemos.attendance;

import com.bailemos.dto.AttendanceRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AttendanceService {

  private final AttendanceRepository attendanceRepository;

  public void createAttendance(AttendanceRequest attendanceRequest) {
    Attendance attendance = Attendance.builder()
        .activityId(attendanceRequest.getActivityId())
        .userId(attendanceRequest.getUserId())
        .role(attendanceRequest.getRole())
        .build();
    attendanceRepository.save(attendance);
  }

  public Set<Long> getAttendingUsersPerActivities(List<Long> activityIds) {
    Set<Long> userIds = new HashSet<>();
    activityIds.forEach(a -> userIds.addAll(getAttendingUsers(a)));
    return userIds;
  }

  public List<Long> getAttendingUsers(Long activityId) {
    List<Attendance> attendances = attendanceRepository.findByActivityId(activityId);
    return attendances.stream().map(Attendance::getUserId).toList();
  }

}
