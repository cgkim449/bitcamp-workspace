package com.eomcs.oop.ex03;

public class Exam02_practice {
  static class A {

    static int v1;
    int v2;

    static void m1() {
      A.v1 = 100;
      v1 = 200;
    }

    void m2() {

      this.v2 = 100;
      v2 = 300;
      v1 = 200;
      A.v1 = 200;
      m1();
      A.m1();
    }

    public static void main(String[] args) {

    }


  }
}
