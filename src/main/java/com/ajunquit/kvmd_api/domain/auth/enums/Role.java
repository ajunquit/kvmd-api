package com.ajunquit.kvmd_api.domain.auth.enums;

public enum Role {
  ADMIN("ADMIN"),
  USER("USER");

  private final String value;

  private Role(final String value) {
    this.value = value;
  }

  public String getValue() { return value; }
}
