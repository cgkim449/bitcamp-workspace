// 실무 : 일단 인스턴스 메서드로 무조건 만들어라!
// 인스턴스 변수를 완전히 사용하지 않음을 확신하면 그 때 클래스 메서드로 전환하라!

// A.멤버, a1.멤버

package com.eomcs.oop.ex03;

public class Exam02 {
  
  static class A {
    
    static int v1;
    int v2;
    
    static void m1() {
      System.out.println("m1()");
      A.v1 = 100;
    }
    
    void m2() {
      System.out.println("m2()");
      this.v2 = 100;
      v2 = 300;
      A.v1 = 200;
      m1();
      A.m1();
    }
    
    int abs(int value) {
      if (value < 0) {
        return value*-1;
      } else {
        return value;
      }
      
    }
  }
  
  public static void main(String[] args) {
    
  }
}