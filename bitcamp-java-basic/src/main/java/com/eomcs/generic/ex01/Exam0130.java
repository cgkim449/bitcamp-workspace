// 여러개의 타입 파라미터
// 식판에 딱 반찬 종류 고정해줌
package com.eomcs.generic.ex01;

public class Exam0130 {
  
  static class A<X,Y,Z> {
    X v1;
    Y v2;
    Z v3;
  }
  
  static class A2<T,S,U> {
    T v1;
    S v2;
    U v3;
  }
  
  public static void main(String[] args) {
    A<String, Integer, Member> obj = new A<>();
    
    obj.v1 = new String("Hello");
    obj.v2 = new Integer(100);
    obj.v3 = new Member("홍길동", 20);
  }
}
