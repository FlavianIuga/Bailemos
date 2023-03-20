package com.bailemos.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.net.URL;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ExternalProfile {//TODO rename ?

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private URL link;

}
