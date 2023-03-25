package com.bailemos.attendance;

import com.bailemos.dto.ActivityResponse;
import com.bailemos.dto.AttendanceActivityResponse;
import com.bailemos.dto.AttendanceRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Log4j2
public class AttendanceService {

  private final AttendanceRepository attendanceRepository;
  private final WebClient.Builder webClientBuilder;

  public void createAttendance(AttendanceRequest attendanceRequest) {
    Attendance attendance = Attendance.builder()
        .activityId(attendanceRequest.getActivityId())
        .userId(attendanceRequest.getUserId())
        .role(attendanceRequest.getRole())
        .build();
    attendanceRepository.save(attendance);
  }

  public Set<Long> getAttendingUsersPerActivities(List<Long> activityIds) {
    return Set.copyOf(
        attendanceRepository.findByActivityIdIn(activityIds).stream().map(Attendance::getUserId)
            .toList());
  }

  public List<Long> getAttendingUsers(Long activityId) {
    List<Attendance> attendances = attendanceRepository.findByActivityId(activityId);
    return attendances.stream().map(Attendance::getUserId).toList();
  }

  public List<AttendanceActivityResponse> getAttendanceActivities(Long eventId, Long userId) {
    List<ActivityResponse> eventActivities = Arrays.stream(webClientBuilder.build().get()
        .uri("http://activity-microservice/api/activity?eventId=" + eventId)
        .retrieve()
        .bodyToMono(ActivityResponse[].class)
        .block()).toList();

    List<Long> eventActivityIds = eventActivities.stream().map(ActivityResponse::getId).toList();

    List<Attendance> attendances = attendanceRepository.findByUserIdAndActivityIdIn(userId,
        eventActivityIds);

    return attendances.stream().map(this::mapToAttendanceActivityResponse).toList();
  }

  private AttendanceActivityResponse mapToAttendanceActivityResponse(Attendance attendance) {
    return AttendanceActivityResponse.builder()
        .activityId(attendance.getActivityId())
        .role(attendance.getRole().getRole())
        .build();
  }
}
