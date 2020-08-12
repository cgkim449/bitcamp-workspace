// 하는일이 다르면 메서드이름이 달라야한다
// 근데 상속된 클래스이다 어떻게 안될까

package com.eomcs.oop.ex06.c;

public class A2 extends A {
  int age;

  void print2() {
    System.out.printf("'%s(%d)'님 반갑습니다!\n", this.name, this.age);
  }
}
