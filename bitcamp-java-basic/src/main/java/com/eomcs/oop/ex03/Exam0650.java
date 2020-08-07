// Class.forName(); : 자바에서 제공하는 도구로 클래스를 로딩할 때

package com.eomcs.oop.ex03;

public class Exam0650 {
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
    Class.forName("com.eomcs.oop.ex03.Exam0650$A");

    System.out.println("종료!");
  }
}
