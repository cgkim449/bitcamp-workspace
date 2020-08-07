// # 스태틱 초기화 블록(static initalizer) 활용 : 클래스 로딩과 스태틱 블록 실행
// # 스태틱 블록의 목적 : 클래스 멤버를 사용하기전에! 초기화시키는것

// 자바는 클래스를 한번에 로딩시키지않고 사용될때 그때 로딩된다
package com.eomcs.oop.ex03;

public class Exam0691 {

  static class A {
    static int a = 7;

    static {
      System.out.println("A.static{}");
      a += B.b;
    }
  }

  static class B {
    static int b = 22;

    static {
      System.out.println("B.static{}");
      b += A.a;
    }
  }

  public static void main(String[] args) {
    System.out.println(A.a);
    System.out.println(B.b);
  }
}
