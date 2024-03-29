package com.bailemos.user;

import com.bailemos.ExternalProfile.ExternalProfile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
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
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "external_profiles_id")
  @Exclude
  private List<ExternalProfile> externalProfiles;

}
