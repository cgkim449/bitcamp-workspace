package com.eomcs.jdbc1.ex1;

import java.sql.DriverManager;

public class Exam0120 {
  //
  public static void main(String[] args) {
    try {
      new org.mariadb.jdbc.Driver();
      new oracle.jdbc.driver.OracleDriver();
      new com.microsoft.sqlserver.jdbc.SQLServerDriver();

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
 * 메서드 area에 클래스로딩 -> 스태틱 블록이 있으면 우선 그걸 실행
 * static {
    try {
      DriverManager.registerDriver(new Driver(), new DeRegister());
    } catch (SQLException e) {
      throw new RuntimeException("Could not register driver", e);
    }
  }
  스태틱 블록에서 지스스로 자기자신을 만들어서 등록시킨다
 * */
