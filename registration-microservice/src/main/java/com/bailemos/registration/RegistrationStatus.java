package com.bailemos.registration;

public enum RegistrationStatus {//TODO add statuses ?
  ENTERED("ENTERED"),
  RECEIVED("RECEIVED"),//TODO redundant ?
  WAITING_LIST("WAITING_LIST"),
  AWAITING_PAYMENT("AWAITING_PAYMENT"),
  PAYMENT_RECEIVED("PAYMENT_RECEIVED"),
  CANCELED("CANCELED"),
  CONFIRMED("CONFIRMED");

  private String status;

  RegistrationStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
