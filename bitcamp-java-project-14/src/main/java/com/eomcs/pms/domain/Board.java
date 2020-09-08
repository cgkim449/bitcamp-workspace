package com.eomcs.pms.domain;

import java.sql.Date;
// - 패키지 멤버 클래스는 스태틱이 될 수 없다
// - 다른 패키지에 있는 클래스가 사용해야 하기 때문에 public으로 공개한다
  public class Board {
    public int no;
    public String title;
    public String content;
    public String writer;
    public Date registeredDate;
    public int viewCount;
  }
