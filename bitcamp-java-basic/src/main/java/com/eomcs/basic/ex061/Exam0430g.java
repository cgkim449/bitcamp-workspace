package com.eomcs.basic.ex061;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0430g {
  public static void main(String[] args) {
    // for 문의 중첩
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(" "+j);
      }
      System.out.println();
    }
  }
}