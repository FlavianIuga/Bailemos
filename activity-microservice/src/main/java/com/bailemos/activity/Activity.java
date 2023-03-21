package com.bailemos.activity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)//TODO which generation type ?
  @Column(name = "id", nullable = false)
  private Long id;

  private Long eventId; // the event this activity belongs to
  private ActivityType activityType;
  private String name;
  private String description;
  private String location; // more detailed type ?
  private Date startDate;
  private Date endDate;
  private Integer price; //TODO implement currency
  private DanceLevel danceLevel;

}
