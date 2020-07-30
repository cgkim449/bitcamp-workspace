package com.eomcs.basic.ex06;

public class Ex0410 {
  public static void main(String[] args) {
// 되도록 i를 for문 바깥에서 선언하지 말자

    for (int i = 1, j = 2; i <= 10; i+=2, j+=2) {
      System.out.printf("%d %d\n", i, j);
    }
  }
}