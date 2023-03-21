package com.bailemos;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {

  private final ActivityService activityService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createActivity(@RequestBody ActivityRequest activityRequest) {
    activityService.createActivity(activityRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ActivityResponse getActivity(@RequestParam Long activityId) {
    return activityService.getActivity(activityId);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<ActivityResponse> getActivities() { //TODO pagination
    return activityService.getAllActivities();
  }

  //TODO get all activity types ?
  //TODO get all dance levels ?
}
