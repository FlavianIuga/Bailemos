package com.bailemos;

public enum ActivityType {
  CLASS("CLASS"),
  PRACTICA("PRACTICA"),
  WORKSHOP("WORKSHOP"),
  TECHNIQUE("TECHNIQUE"),
  PRIVATE_LESSON("PRIVATE_LESSON"),
  DANCE_PARTY("DANCE_PARTY"),
  MILONGA("MILONGA"),
  SOCIAL("SOCIAL"),
  PERFORMANCE("PERFORMANCE"),
  CONCERT("CONCERT");

  private String type;

  ActivityType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
