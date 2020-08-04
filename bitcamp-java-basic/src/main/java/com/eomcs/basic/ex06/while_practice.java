package com.eomcs.basic.ex06;

public class while_practice {
  public static void main(String[] args) {

    //ex04
    int x = 2;
    int y = 1;

    while (x <= 9) {
      y = 1;
      while (y <= 9) {
        System.out.printf("%d x %d = %d\n", x, y, x*y);
        y++;
      }
      x++;
    }
    // #
    // - 프린트 위에 후위 등 연산 있으면 당연히 좋지않다
    // - 중첩에서 안에 while 끝나면 당연히 밑에있는 문장으로 간다

    int count = 0;
    int sum = 0;

    while (count++ < 100) {
      sum += count;
    }
    System.out.printf("%d, %d\n", sum, count);

    // #
    // - (count++ < 100) .. : 단 하나도 빼먹으면 안된다


  }
}