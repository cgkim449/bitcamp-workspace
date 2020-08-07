// # 클래스 멤버가 사용될 때 클래스가 로딩된다

package com.eomcs.oop.ex03;

public class Exam0630 {
  public static class A {
    static int a;
    static void m() {}

    static {
      System.out.println("1");
    }
    static {
      System.out.println("2");
    }
  }

  public static void main(String[] args) throws Exception {
    A.m();
    System.out.println("exit");
  }
}
