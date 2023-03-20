package com.bailemos.user;

import com.bailemos.ExternalProfile.ExternalProfile;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

  private Long id;
  private String handle;
  private String name;
  private String description;
  private String email;
  private Date dateOfBirth;
  private String location;
  private List<ExternalProfile> externalProfiles;
}
