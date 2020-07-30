package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test03 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    System.out.print("밑변 길이? ");
    int length = keyScan.nextInt();

    for (int i = 1; i <= length; i++) {
      if(i % 2 == 0) {
        continue;
      }
      for (int j = 1; j <= (length-i)/2; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("$");
      }
      for (int j = 1; j <= (length-i)/2; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }

    keyScan.close();
  }
}