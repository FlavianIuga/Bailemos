package com.bailemos.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {

  private Long id;
  private Long eventId; // the event this activity belongs to
  private String activityType;
  private String name;
  private String description;
  private String location; // more detailed type ?
  private Date startDate;
  private Date endDate;
  private Integer price; //TODO implement currency
  private String danceLevel;
}
