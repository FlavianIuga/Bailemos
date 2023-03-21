package com.bailemos.activity;

public enum DanceLevel {
  BEGINNER("BEGINNER"),
  INTERMEDIATE("INTERMEDIATE"),
  ADVANCED("ADVANCED");

  private String level;

  DanceLevel(String level) {
    this.level = level;
  }

  public String getDanceLevel() {
    return level;
  }
}
