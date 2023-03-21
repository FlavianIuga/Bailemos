package com.bailemos;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ActivityService {

  private final ActivityRepository activityRepository;

  public void createActivity(ActivityRequest activityRequest) {
    Activity activity = Activity.builder()
        .eventId(activityRequest.getEventId())
        .activityType(activityRequest.getActivityType())
        .name(activityRequest.getName())
        .description(activityRequest.getDescription())
        .location(activityRequest.getLocation())
        .startDate(activityRequest.getStartDate())
        .endDate(activityRequest.getEndDate())
        .price(activityRequest.getPrice())
        .danceLevel(activityRequest.getDanceLevel())
        .build();

    activityRepository.save(activity);
  }

  public ActivityResponse getActivity(Long activityId) {
    Activity activity = activityRepository.findById(activityId).orElseThrow();
    return mapToActivityResponse(activity);
  }

  public List<ActivityResponse> getAllActivities() {
    List<Activity> activities = activityRepository.findAll();
    return activities.stream().map(this::mapToActivityResponse).toList();
  }

  private ActivityResponse mapToActivityResponse(Activity activity) {
    return ActivityResponse.builder()
        .id(activity.getId())
        .eventId(activity.getEventId())
        .activityType(activity.getActivityType())
        .name(activity.getName())
        .description(activity.getDescription())
        .location(activity.getLocation())
        .startDate(activity.getStartDate())
        .endDate(activity.getEndDate())
        .price(activity.getPrice())
        .danceLevel(activity.getDanceLevel())
        .build();
  }
}
