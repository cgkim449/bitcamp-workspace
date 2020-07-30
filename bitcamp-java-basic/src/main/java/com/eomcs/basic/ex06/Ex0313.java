package com.eomcs.basic.ex06;

public class Ex0313 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;

    while (count++ < 20) {
      if (count > 5) { // 유지보수 : 직관적, 가독성, 일관성, 낡은방식이더라도
        break; // 반복문, 스위치
      }
      sum += count;
    }
    System.out.printf("%d", sum);
    System.out.println("------------------");

  }
}