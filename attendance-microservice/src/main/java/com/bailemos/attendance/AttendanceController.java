package com.bailemos.attendance;

import com.bailemos.dto.AttendanceActivityResponse;
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

  @GetMapping("/activitiesUsers")
  @ResponseStatus(HttpStatus.OK)
  public Set<Long> getActivitiesAttendingUsers(@RequestParam List<Long> activityIds) {
    return attendanceService.getAttendingUsersPerActivities(activityIds);
  }

  @GetMapping("/activityUsers")
  @ResponseStatus(HttpStatus.OK)
  public List<Long> getActivityAttendingUsers(@RequestParam Long activityId) {
    return attendanceService.getAttendingUsers(activityId);
  }

  @GetMapping("/activities") //TODO redesign
  @ResponseStatus(HttpStatus.OK)
  public List<AttendanceActivityResponse> getAttendanceActivities(@RequestParam Long eventId,
      @RequestParam Long userId) {
    return attendanceService.getAttendanceActivities(eventId, userId);
  }
}
