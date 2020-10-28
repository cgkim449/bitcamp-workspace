package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0110 {
  //
  public static void main(String[] args) {
    try {
      // 드라이버 구현체를 문서를 보고 알아낸다
      java.sql.Driver driver = new org.mariadb.jdbc.Driver();
      // 등록한다
      DriverManager.registerDriver(driver);
      System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
      // 없으면 null 리턴 안함 아예 예외띄움 no suitable driver : 적합한 드라이버 없음
      // 마리아디비는 mysql과 호환되서 mysql도 있다
      java.sql.Driver driver2 = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
