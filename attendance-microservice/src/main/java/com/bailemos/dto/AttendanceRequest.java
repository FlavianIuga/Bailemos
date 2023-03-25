package com.bailemos.dto;

import com.bailemos.attendance.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRequest {

  private Long activityId;
  private Long userId;
  private Role role;
}
