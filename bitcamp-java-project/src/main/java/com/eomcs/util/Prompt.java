package com.eomcs.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  public static Scanner keyboardScan = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  public static void close() {
    keyboardScan.close();
  } // ! 너가 사용한 자원있으면 너가 닫아라
}
