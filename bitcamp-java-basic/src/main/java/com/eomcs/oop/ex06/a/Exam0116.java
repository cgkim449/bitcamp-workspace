// 다형성 - 다형적 변수(polymorphic variables) : 상위클래스로 하위클래스를 가리킬때
// - 주소값이 누구를 가리키는지, 설계

// - (내 실수)단순 주소값이 아니라 그 주소가 어떤 인스턴스를 가리키는지

// 일단 주소값과 설계는 갖고있다.. 나도 속고 컴파일러도 속았다..
// 근데 가리키는 인스턴스가 Car이다 주소가 Car의 주소다
//

package com.eomcs.oop.ex06.a;

public class Exam0116 {

  public static void main(String[] args) {

    // 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬 때
    Car c = new Car();

    c.model = "티코"; // Vehicle의 인스턴스 변수
    c.capacity = 5;  // Vehicle의 인스턴스 변수
    c.cc = 890;      // Car의 인스턴스 변수
    c.valve = 16;    // Car의 인스턴스 변수

    // 형변환(type casting)으로 컴파일러를 속일 수는 있지만,
    // 실행할 때 오류가 발생할 것이다.
    // => 속이지 말라!
    Sedan s = (Sedan) c; // 실행할 때 오류 발생! (runtime exception)
    s.sunroof = true;
    s.auto = true;

  }

}










