package com.eomcs.oop.ex03;

public class Practice {
  static class A {
    static int v1;
    static boolean v2;
  }

  public static void main(String[] args) {

    A obj1 = new A();
    A obj2 = new A();

    obj1.v1 = 100;
    obj2.v1 = 200;

    System.out.println(obj1.v1);
    System.out.println(obj2.v1);
  }
}
