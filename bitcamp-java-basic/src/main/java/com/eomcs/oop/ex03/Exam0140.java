package com.eomcs.oop.ex03;

public class Exam0140 {
  static class A {
    static int v1;
    int v2;
  }

  public static void main(String[] args) {
    A.v1 = 100;
    A obj1 = new A();
    A obj2 = new A();
    obj1.v2 = 200;
    obj2.v2 = 200;
    System.out.println(A.v1);
    System.out.println(obj1.v1);
    System.out.println(obj2.v1);
    System.out.println(obj1.v2);
    System.out.println(obj2.v2);
  }
}
