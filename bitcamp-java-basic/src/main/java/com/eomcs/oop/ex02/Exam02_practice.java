package com.eomcs.oop.ex02;

import com.eomcs.util.Calculator;

public class Exam02_practice {

  public static void main(String[] args) {
    // 3 + 4 - 5 * 8 / 2 = ?
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(3);
    c2.plus(3);
    c1.plus(4);
    c2.plus(4);
    c1.minus(5);
    c2.minus(5);
    c1.multiple(8);
    c2.multiple(8);
    c1.divide(2);

    printResult(c1);
    printResult(c2);
  }

  static void printResult(Calculator c) {
    System.out.println(c.result);
  }

}