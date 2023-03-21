package com.bailemos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

  private Long id;
  private String name;
  private String description;
  private Long userId; // the user this event belongs to
  private EventType eventType;
  private Date startDate;
  private Date endDate;
}
