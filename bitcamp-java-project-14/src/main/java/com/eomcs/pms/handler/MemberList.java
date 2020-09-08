package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class MemberList {

  static final int DEFAULT_CAPACITY = 100;
  Member[] list = new Member[DEFAULT_CAPACITY];
  int size = 0;


}
