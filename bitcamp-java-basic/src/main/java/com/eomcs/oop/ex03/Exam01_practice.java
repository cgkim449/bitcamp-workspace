package com.eomcs.oop.ex03;

public class Exam01_practice {
  static class A {
    static int v1;
    int v2;
  }

  public static void main(String[] args) {

    A.v1 = 100;

    A obj1 = new A();
    A obj2 = new A();

    obj1.v2 =200;
    obj1.v2 =200;
  }
}
