package com.bailemos.attendance;

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

}
