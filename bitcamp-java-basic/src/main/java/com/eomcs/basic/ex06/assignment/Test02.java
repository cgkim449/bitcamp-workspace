package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    System.out.print("밑변 길이? ");
    int length = keyScan.nextInt();

    for (int i = 1 ; i<=length; i++) {
      for (int j = 1 ; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = length-1 ; i >= 1; i--) {
      for (int j = 1 ; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }


    keyScan.close();
  }
}