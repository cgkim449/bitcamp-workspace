package com.eomcs.oop.ex02;

import com.eomcs.util.Calculator1;

public class Exam0220 {
  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?
    Calculator1 c1 = new Calculator1();
    Calculator1 c2 = new Calculator1();

    c1.plus(3);
    c2.minus(1);
    c1.multiple(7);
    printResult(c1.result);
    printResult(c2.result);

  }
  static void printResult(int result) {
    System.out.println(result);
  }
}