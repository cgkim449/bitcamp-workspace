// 얘가 worker 구현체구나
// worker를 구현한다
// worker의 규칙을 구현한다
// worker의 추상메서드들을 모두 구현한다

package com.eomcs.oop.ex09.a.after;

public class JubuWorker implements Worker {
  @Override
  public void execute() { // 오버라이딩이구나 이것도 그럼 당연히 public을 못줄이지 그래서 무조건 public이네
    System.out.println("주부로 일합니다");
  }
}
