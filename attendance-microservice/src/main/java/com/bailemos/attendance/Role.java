package com.bailemos.attendance;

public enum Role {
  PARTICIPANT("PARTICIPANT"),
  DJ("DJ"),
  MC("MC"),
  INSTRUCTOR("INSTRUCTOR"), //TODO go with teacher ?
  MAESTRO("MAESTRO"),
  PERFORMER("PERFORMER"),
  TAXI_DANCER("TAXI_DANCER"),
  HELPER("HELPER"),
  PHOTOGRAPHER("PHOTOGRAPHER"),
  MASSEUR("MASSEUR"),
  RETAILER("RETAILER"),
  TECHNICIAN("TECHNICIAN"),
  MUSICIAN("MUSICIAN"),
  OTHER("OTHER");

  private String role;

  Role(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
