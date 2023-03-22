package com.bailemos.attendance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

  private final AttendanceService attendanceService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createAttendance(@RequestBody AttendanceRequest attendanceRequest) {
    attendanceService.createAttendance(attendanceRequest);
  }
}