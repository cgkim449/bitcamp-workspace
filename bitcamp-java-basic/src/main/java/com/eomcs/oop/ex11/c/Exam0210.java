// inner class : 다른 멤버에 접근하기
// inner class는 인스턴스 메서드로 생각하자
// 인스턴스 멤버인 inner class는 스태틱 멤버, 인스턴스 멤버를 모두 사용할 수 있다
package com.eomcs.oop.ex11.c;

class B {
  // 클래스 멤버
  static int v1;
  static void m1() {}

  // 인스턴스 멤버
  int v2;
  void m2() {}

  class X {
    void test() {
      // 같은 클래스 멤버 접근 가능
      B.v1 = 100;
      B.m1();

      // 바깥 클래스 이름 생략 가능
      v1 = 200; 
      m2(); 

      // 인스턴스 멤버에 접근 가능
      v2 = 100; 
      m2(); 
    }
  }
}

public class Exam0210 {

  public static void main(String[] args) {
    B outer = new B();

    B.X obj = outer.new X();
    obj.test();

    System.out.println(B.v1);
    System.out.println(outer.v2);
  }

}
