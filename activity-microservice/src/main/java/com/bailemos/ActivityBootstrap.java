package com.bailemos;

import com.bailemos.activity.Activity;
import com.bailemos.activity.ActivityRepository;
import com.bailemos.activity.ActivityType;
import com.bailemos.activity.DanceLevel;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityBootstrap implements CommandLineRunner {

  private final ActivityRepository activityRepository;

  @Override
  public void run(String... args) {
    Activity a1 = new Activity(1L, 1L, ActivityType.MILONGA, "Activity 1", "Description Activity 1",
        "Timisoara", new Date(), new Date(), 30, DanceLevel.BEGINNER);
    Activity a2 = new Activity(2L, 1L, ActivityType.MILONGA, "Activity 2", "Description Activity 2",
        "Timisoara", new Date(), new Date(), 40, DanceLevel.INTERMEDIATE);
    Activity a3 = new Activity(3L, 1L, ActivityType.MILONGA, "Activity 3", "Description Activity 3",
        "Timisoara", new Date(), new Date(), 50, DanceLevel.ADVANCED);
    activityRepository.save(a1);
    activityRepository.save(a2);
    activityRepository.save(a3);
  }


}
