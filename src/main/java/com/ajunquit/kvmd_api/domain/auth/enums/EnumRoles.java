package com.ajunquit.kvmd_api.domain.auth.enums;

public enum EnumRoles {
  ADMIN_SYSTEM("ADMIN_SYSTEM"),
  SINGLE_USER("SINGLE_USER");

  private final String value;

  private EnumRoles(final String value) {
    this.value = value;
  }

  public String getValue() { return value; }
}
