package com.eomcs.jdbc1.ex1;

import java.sql.DriverManager;

public class Exam0130 {
  //
  public static void main(String[] args) {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      // 이런 이름의 클래스를 메서드 에어리어에 로딩하라는 명령어
      // 클래스 로딩 -> 스태틱 블록이 있으면 스태틱 블록을 먼저 실행
      // Class : 클래스 정보를 다루는 클래스

      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb://");
      System.out.println(driver);
      java.sql.Driver driver2 = DriverManager.getDriver("jdbc:oracle:thin://");
      System.out.println(driver2);
      java.sql.Driver driver3 = DriverManager.getDriver("jdbc:sqlserver://");
      System.out.println(driver3);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
/*
 *
 * */
