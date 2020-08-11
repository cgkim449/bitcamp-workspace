// 인스턴스 초기화 블록(instance initializer) - 인스턴스 초기화 블록과 생성자
// - 인스턴스 블록은 어디에 위치해있건 무조건 생성자 맨 앞부분에 삽입된다
package com.eomcs.oop.ex03eom;

public class Exam0720 {
  static class A {
    int a;
    int b;
    int c;

    {
      a = 100;
      System.out.println("인스턴스 초기화 블록 실행!");
    }

    public A() {
      a = 200;
      System.out.println("A() 생성자 호출");
    }
  }

  public static void main(String[] args) {
    A obj1 = new A();
    System.out.printf("a=%d, b=%d, c=%d\n", obj1.a, obj1.b, obj1.c);
  }
}
