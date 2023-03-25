package com.bailemos.attendance;

import com.bailemos.dto.AttendanceRequest;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

  private final AttendanceService attendanceService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createAttendance(@RequestBody AttendanceRequest attendanceRequest) {
    attendanceService.createAttendance(attendanceRequest);
  }

  @GetMapping("/users")
  @ResponseStatus(HttpStatus.OK)
  public Set<Long> getAttendingUsers(@RequestParam List<Long> activityIds) {
    return attendanceService.getAttendingUsersPerActivities(activityIds);
  }
}
