// 실무 : 일단 인스턴스 메서드로 무조건 만들어라!
// 인스턴스 변수를 완전히 사용하지 않음을 확신하면 그 때 클래스 메서드로 전환하라!

package com.eomcs.oop.ex03;

public class Exam02 {
  static class A {
    int value;

    static void m1() {
    }
    void m2() {
    }
    void m3() {
      value = 200;
    }
    void m4(int value) {
      value = 200; // 로컬 변수
      this.value = 200; // 인스턴스 변수
    }

  }
  public static void main(String[] args) {
    A.m1();

    A obj1 = new A();

    obj1.m2();

    A obj2 = null;
    obj2.m2();

  }
}
