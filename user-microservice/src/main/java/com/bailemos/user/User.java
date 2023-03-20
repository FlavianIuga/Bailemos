package com.bailemos.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)//TODO which generation type ?
  @Column(name = "id", nullable = false)
  private Long id;

  private String handle; // public handle //TODO for external use ?
  private String name;
  private String description;
  private String email;
  private Date dateOfBirth;
  private String location;
  private List<Integer> danceTypes;//TODO to see
//  private Map<String, URL> externalProfiles;//TODO rename ? implement latter
  private List<Integer> roles; // role id's

}
