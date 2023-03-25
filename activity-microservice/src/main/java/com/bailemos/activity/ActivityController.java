package com.bailemos.activity;

import com.bailemos.dto.ActivityRequest;
import com.bailemos.dto.ActivityResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {

  private final ActivityService activityService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createActivity(@RequestBody ActivityRequest activityRequest) {
    activityService.createActivity(activityRequest);
  }

  @GetMapping("/{activityId}")
  @ResponseStatus(HttpStatus.OK)
  public ActivityResponse getActivity(@PathVariable Long activityId) {
    return activityService.getActivity(activityId);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<ActivityResponse> getActivities() { //TODO pagination
    return activityService.getAllActivities();
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ActivityResponse> getActivitiesOfEvent(@RequestParam Long eventId) {
    return activityService.getActivitiesByEventId(eventId);
  }

  //TODO get all activity types ?
  //TODO get all dance levels ?
}
