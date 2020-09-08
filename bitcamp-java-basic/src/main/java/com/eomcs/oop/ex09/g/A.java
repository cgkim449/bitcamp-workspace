package com.eomcs.oop.ex09.g;

public interface A {

  //인터페이스도 static 메서드를 가질 수 있다
  static String m1() {
    return "안녕하세요!";
  }

  default void m2() {
    // 얘도 규칙이다, 근데 이미 구현돼있는거다, 따라서 추상 메서드는 아니다
    // 근데 추상메서드처럼 몸체 정의 안되있네 얘는,
    // 근데도 이미 구현돼있는거다 그런 의도로 만들어진 문법임
    // 구현체가 얘를 구현하게끔 강제하진 못함
  }

  // 추상 메서드는 얘 한개뿐! static메서드나 default 메서드는 이미 구현된 메서드이기때문이다!
  // 구현되지 않는 메서드만이 추상메서드이다!
  void m3();
}
