package com.eomcs.oop.ex03;

public class Exam0210 {
  static class A {

    static int v1; // 클래스가 로딩될때 Method Area에 v1이라는 변수 만들어라 // 스태틱 변수 = static field = class field
    int v2; // 인스턴스 변수 = instance field = nonstatic field

    static void m1() {
      System.out.println("m1()");
      A.v1 = 100;
      v1 = 200;// 같은 스태틱 멤버이기 때문에 생략가능

      // 스태틱 메서드는 this라는 내장변수가 없다
//      v2 = 200;
      // m2();  ??
      // 스태틱 메서드는 this라는 내장 변수가 없기 때문에
      // this를 사용하여 접근하는 인스턴스 멤버(필드, 메서드)를 사용할 수 없다
    }

    void m2() { // 인스턴스 메서드를 만드는 이유는 딱 하나 : 인스턴스 필드가 없으면 못씀
      System.out.println("m2()");
      // 인스턴스 필드에 접근하려면
      // 메서드 내장 변수인 this를 사용하라
      // 메서드가 호출될때 외부로부터 받은 인스턴스 주소를 갖고있다

      this.v2 = 100; // A.v1 = 100;
      v2 = 300; // 코드를 작성할 때 this를 생략할 수 잇다
      // 스태틱 필드는 인스턴스 레퍼런스를 통해 접근할 수 있다
      v1 = 200; // (this 생략) A.v1 = 200; 반반
      A.v1 = 200; // 이게 원칙 // 이탤릭체는 스태틱
      m1();
      A.m1();
      //인스턴스 메서드는 인스턴스 멤버(필드나 메서드)뿐만 아니라
      //클래서 멤버도 사용할 수 있다
    }

    int abs(int value) { // 인스턴스 메서드를 만드는 이유는 딱 하나 : 인스턴스 필드가 없으면 못씀
      // 얘는 스태틱을 붙여라
      if (value < 0) {
        return value * -1;
      } else {
        return value;
      }

    }
  }
  public static void main(String[] args) {
    A.m1();

    A obj1 = new A();
    obj1.m2();

    System.out.println(obj1.abs(100));
    System.out.println(obj1.abs(-100));
    System.out.println(Math.abs(-100));
  }
}