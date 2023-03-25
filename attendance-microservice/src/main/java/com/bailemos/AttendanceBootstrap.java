package com.bailemos;

import com.bailemos.attendance.Attendance;
import com.bailemos.attendance.AttendanceRepository;
import com.bailemos.attendance.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendanceBootstrap implements CommandLineRunner {

  private final AttendanceRepository attendanceRepository;

  @Override
  public void run(String... args) {
    Attendance a1 = new Attendance(1L, 1L, 1L, Role.PARTICIPANT);
    Attendance a2 = new Attendance(2L, 1L, 2L, Role.PARTICIPANT);
    Attendance a3 = new Attendance(3L, 1L, 3L, Role.PARTICIPANT);
    Attendance a4 = new Attendance(4L, 2L, 1L, Role.DJ);
    Attendance a5 = new Attendance(5L, 2L, 2L, Role.MC);
    Attendance a6 = new Attendance(6L, 3L, 3L, Role.RETAILER);
    attendanceRepository.save(a1);
    attendanceRepository.save(a2);
    attendanceRepository.save(a3);
    attendanceRepository.save(a4);
    attendanceRepository.save(a5);
    attendanceRepository.save(a6);
  }
}
