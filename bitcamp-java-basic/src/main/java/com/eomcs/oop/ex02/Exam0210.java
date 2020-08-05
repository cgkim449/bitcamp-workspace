package com.eomcs.oop.ex02;

public class Exam0210 {
  static class Calculator1 {
    static int result = 0;
    static void plus(int b) {
      result += b;
    }
    static void minus(int b) {
      result -= b;
    }
    static void multiple(int b) {
      result *= b;
    }
    static void divide(int b) {
      result /= b;
    }
  }
  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?
    Calculator1.plus(3);
    Calculator1.minus(1);
    Calculator1.multiple(7);
    Calculator1.divide(3);
    printResult(Calculator1.result);

  }
  static void printResult(int result) {
    System.out.println(result);
  }
}