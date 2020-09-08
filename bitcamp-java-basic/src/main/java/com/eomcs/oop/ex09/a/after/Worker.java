
package com.eomcs.oop.ex09.a.after;

// caller : Exam01
// callee : BlueWorker, JubuWorker, WhiteWorker
// 문법 :
//  interface 사용규칙명 {...}

public interface Worker {

  // 호출규칙?
  // 메서드 **형식**을 의미한다 (이름?)
  // 메서드 몸체는 정의하지 않는다 (추상메서드랑 똑같네)

  void execute(); // 인터페이스는 모든 메서드가 추상메서드 
  // 그리고 규칙이므로 공개되어야한다
  // 따라서 public abstract
}
