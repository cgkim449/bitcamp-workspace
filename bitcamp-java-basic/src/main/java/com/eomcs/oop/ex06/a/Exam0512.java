// 다형성 - 다형적 변수와 getClass()
// getClass()
// => 레퍼런스가 가리키는 인스턴스의 실제 클래스 정보를 리턴한다.
// => == 연산자를 사용하여 특정 클래스의 인스턴스인지 좁혀서 검사할 수 있다.
package com.eomcs.oop.ex06.a;

public class Exam0512 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();

    // getClass() ?
    // => 레퍼런스가 가리키는 인스턴스의 실제 클래스 정보를 리턴한다.
    // => == 연산자를 사용하여 특정 클래스의 인스턴스인지 좁혀서 검사할 수 있다.
    //
    System.out.println(v.getClass() == Sedan.class); // class라는 스태틱 변수(클래스 정보가 들어있다) 안만들어도 자동으로 만들어짐
    System.out.println(v.getClass() == Car.class);
    System.out.println(v.getClass() == Vehicle.class);
    System.out.println(v.getClass() == Truck.class);
    System.out.println(v.getClass() == Bike.class);
  }

}




