package com.eomcs.jdbc1.ex1;

import java.sql.DriverManager;

public class Exam0110 {
  //
  public static void main(String[] args) {
    try {
      // 우리는 Driver 구현체가 어떤건지를 문서를 보고 알아낸다
      java.sql.Driver mariadbDriver = new org.mariadb.jdbc.Driver();
      java.sql.Driver oracleDriver = new oracle.jdbc.OracleDriver();
      java.sql.Driver mssqlDriver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();

      // 등록한다
      DriverManager.registerDriver(mariadbDriver);
      DriverManager.registerDriver(oracleDriver);
      DriverManager.registerDriver(mssqlDriver);
      System.out.println("JDBC 드라이버 로딩 및 등록 완료!");

      // 없으면 null 리턴 안함 아예 예외띄움 no suitable driver : 적합한 드라이버 없음
      // 마리아디비는 mysql과 호환되서 mysql도 있다
      // 우리는 url을 구글검색으로 알아낸다
      // jdbc : 프로토콜
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb://");
      System.out.println(driver);
      java.sql.Driver driver2 = DriverManager.getDriver("jdbc:oracle:thin://");
      // url이름이 다르니까
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
