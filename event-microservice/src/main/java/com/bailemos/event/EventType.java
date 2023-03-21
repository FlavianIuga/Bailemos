package com.bailemos.event;

public enum EventType { //TODO should leave it as String ?
  FESTIVAL("FESTIVAL"),
  FESTIVALITO("FESTIVALITO"),
  MARATHON("MARATHON"),
  ENCUENTRO("ENCUENTRO"),
  CONGRESS("CONGRESS"),
  DANCE_CAMP("DANCE_CAMP"),
  CHAMPIONSHIP("CHAMPIONSHIP"),
  CLASSES("CLASSES");

  private final String type;

  EventType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
