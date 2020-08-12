// 오버라이딩(overriding) - 필드 오버라이딩
package com.eomcs.oop.ex06.c;

public class Exam0140 {
  public static void main(String[] args) {
    A4 obj1 = new A4();
    obj1.name = "홍길동";
    obj1.age = "20";
    //obj1.super.age = 20; // 컴파일 오류!

    ((A3)obj1).age = 20; // 필요없음
    // 형변환한 레퍼런스의 클래스를 기준으로 인스턴스 변수를 찾는다

    obj1.print(); // 경력자 : obj1 프린트해
    obj1.print3(); // 초보 : 단항연산자, 이항연산자, ... , n항연산자
    System.out.println("-----------------");

    obj1.test();
  }
}








