package com.eomcs.basic.ex06;

public class while_ex3 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;

    while (count++ < 100) {
      sum += count;
    }
    System.out.printf("%d, %d\n", sum, count);

    System.out.println("-------------------------------------");
    count = 0;
    sum = 0;

    while (count++ < 100) {
      if (count > 50) {
        continue;
      }
      sum += count;
    }
    System.out.printf("%d, %d\n", sum, count);

    System.out.println("-------------------------------------");

    count = 0;
    sum = 0;

    while (count++ < 100) {
      if (count > 50) {
        break;
      }
      sum += count;
    }
    System.out.printf("%d, %d\n", sum, count);

    System.out.println("-------------------------------------");

    count = 0;
    sum = 0;
    while (count++ < 20) {
      if (count > 5) { // 유지보수 : 직관적, 가독성, 일관성, 낡은방식이더라도
        break; // 반복문, 스위치
      }
      sum += count;
    }
    System.out.printf("%d\n", sum);
    System.out.println("-------------------------------------");



  }
}