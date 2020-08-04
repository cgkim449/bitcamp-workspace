package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test05 {
  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("너비는? ");
    int fat = keyScan.nextInt();
    System.out.print("높이는? ");
    int tall = keyScan.nextInt();
    
    for (int i = 1 ; i <= tall; i++) {
      for (int j = 1; j <= fat; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    keyScan.close();
  }
}
