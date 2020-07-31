package com.eomcs.basic.ex06;

public class while_ex4 {
  public static void main(String[] args) {

    int x = 2;
    int y = 1;

    loop : while (x<=9) {
      y=1;
      while (y<=9) {
        System.out.printf("%d x %d = %d\n", x, y, x*y);
        if (x == 5 && y == 5) {
          break loop;
        }
        y++;
      }
      x++;
    }
  }
}