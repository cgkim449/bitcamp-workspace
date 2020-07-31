package com.eomcs.basic.ex06;

public class while_ex2 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;

    while (count < 100) {
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