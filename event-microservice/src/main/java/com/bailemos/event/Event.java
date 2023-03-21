package com.bailemos.event;

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
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)//TODO which generation type ?
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;
  private String description;
  private Long userId; // the user this event belongs to
  private EventType eventType;
  private Date startDate;
  private Date endDate;

}
