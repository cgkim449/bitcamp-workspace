package com.eomcs.oop.ex12;


public class Exam0500p {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  static interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {
  }
}


