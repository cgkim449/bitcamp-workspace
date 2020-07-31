package com.eomcs.basic.ex06;

public class switch_enum_ex {

  enum Level {
    GUEST, MEMBER, ADMIN
  }

  public static void main(String[] args) {

    Level level = Level.GUEST;

    switch (level) {
      case GUEST:
      case MEMBER:
      case ADMIN:
    }

  }
}
