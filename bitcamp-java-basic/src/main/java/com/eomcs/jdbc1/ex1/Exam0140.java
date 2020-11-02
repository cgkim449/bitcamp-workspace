package com.eomcs.jdbc1.ex1;

import java.sql.DriverManager;

public class Exam0140 {
  //
  public static void main(String[] args) {
    /*
     *jvm 시스템 프로퍼티스 : jvm이 사용하는 변수값 목록
     *System : jvm을 관리하는 클래스
     */
    //    System.out.printf("java.home=%s\n", System.getProperty("java.home"));
    /*
     * 현재 사용자 홈폴더를 알아낼수있다
     */
    //    System.out.printf("user.home=%s\n", System.getProperty("user.home"));
    System.setProperty("jdbc.drivers", "org.mariadb.jdbc.Driver:com.eomcs.jdbc.ex1.MyDriver");
    System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.drivers"));
    try {
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
