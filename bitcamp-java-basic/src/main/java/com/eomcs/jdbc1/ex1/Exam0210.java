package com.eomcs.jdbc1.ex1;

import java.sql.DriverManager;
import org.mariadb.jdbc.MariaDbConnection;

public class Exam0210 {
  //
  public static void main(String[] args) {
    try {
      /*
       *
       */
      MariaDbConnection con = (MariaDbConnection) DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb",
          "study",
          "1111"
          );

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
/*
 *
 * */
