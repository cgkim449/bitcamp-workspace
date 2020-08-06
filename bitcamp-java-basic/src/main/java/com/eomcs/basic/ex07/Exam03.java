// 1. call by value VS call by reference
// 2. 변수덩어리 class(== 새로운 데이터 타입!)

// C언어
// 인스턴스 메서드는 C++에 있다
// 객체지향언어는 유지보수를 중시 그래서 인스턴스 매서드 같은거 만들어서 간결성

package com.eomcs.basic.ex07;

public class Exam03 {

  static class Person {
    String name;
    int age;
    boolean working;
  }

  public static void main(String[] args) {
    int a = 200;

    m1(a); // call by vlaue

    System.out.println(a);

    a = 300;

    m1(a);

    System.out.println(a);

    int[] arr = new int[3];
    arr[0] = 100;
    arr[1] = 200;
    arr[2] = 300;

    m2(arr); // call by reference // java에서는 primitive 변수의 주소를 넘길수는 없다!, C는 가능
    // 인스턴스로 만들어서 묶어서 넘길 수 있다

    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);

    System.out.println("----------------------");

    Person p = new Person();
    System.out.printf("%s %d %b\n", p.name, p.age, p.working);
    m3(p);
    System.out.printf("%s %d %b\n", p.name, p.age, p.working);
  }

  static void m3(Person p) {
    p.name = "홍길동";
    p.age = 20;
    p.working = true;
  }

  static void m1(int a) {
    a = 100;
  }

  static void m2(int[] arr) {
    arr[0] *= 2;
    arr[1] *= 3;
    arr[2] *= 4;
  }
}