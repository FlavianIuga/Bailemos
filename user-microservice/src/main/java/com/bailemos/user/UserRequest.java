package com.bailemos.user;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

  private String handle; // public handle
  private String name;
  private String description;
  private String email;
  private Date dateOfBirth;
  private String location;
  private List<Integer> danceTypes;
//  private Map<String, URL> externalProfiles;//TODO rename ?
  private List<Integer> roles; // role id's
}
