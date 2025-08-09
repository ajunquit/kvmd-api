package com.ajunquit.kvmd_api.domain.auth.enums;

public enum UserStatus {  
  CREATED(1),
  ACTIVE(2),
  INACTIVE(3),
  BLOCKED(4),
  UNKNOWN(0);

  private final int code;

  UserStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
  
  public static UserStatus fromCode(int code) {
    for (UserStatus status : UserStatus.values()) {
      if (status.getCode() == code) {
        return status;
      }
    }
    return UNKNOWN;
  }
}
