package com.eomcs.basic.ex06;

public class Ex0311 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;

    while (count < 100) { // 1부터 시작해서 <=100가 이해하기 제일 명확하나 두번 연산함, C개발자들
      count++;
      sum = sum + count;
    }
    System.out.printf("%d\n",sum);

    System.out.println("---------------------------");

    while (count < 100) {
      sum = sum + ++count;
    }
    System.out.printf("%d\n",sum);

    System.out.println("---------------------------");

    while (count++ < 100) {
      sum = sum + count;
    }
    System.out.printf("%d\n",sum);

    System.out.println("---------------------------");
  }
}