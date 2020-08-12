  // Score 설계도에 따라 Heap에 확보한 메모리의 주소를 리턴
  // Score 클래스에 따라 Heap에 확보한 인스턴스 주소를 리턴
  // Score 클래스의 인스턴스를 확보한 후 그 주소를 리턴
  // Score 클래스의 인스턴스를 리턴
  // Score의 인스턴스를 리턴
  // Score 객체를 리턴

  // 걍 그림

// JVM이 메모리를 다루는 방법
// - 크게 다음 세가지 영역으로 나눠 관리한다.
//
// 1) Method Area
// - 클래스 명령 코드를 둔다.
// - static 변수를 둔다.
//
// 2) Heap
// - new 명령으로 만든 메모리(인스턴스=객체)를 둔다.
// - Garbage Collector(GC)가 관리하는 영역이다.
//
// 3) JVM Stack
// - 스레드 별로 JVM Stack 메모리를 따로 관리한다.
// - 메서드의 로컬 변수는 둔다.
// - 각 메서드마다 프레임 단위로 관리한다.
// - 메서드 호출이 끝나면 그 메서드가 사용한 프레임 메모리가 제거된다.
// - 이렇게 메서드가 호출될 때 로컬 변수가 준비되고
//   맨마지막에 호출한 메서드가 먼저 삭제된다고 해서
//   "스택(stack)" 메모리라 부른다.
//   스택? 접시 쌓는 것을 생각하라!
// - 스택 방식을 "Last In First Out(LIFO;후입선출)"라 부른다.
//
// JVM이 종료하면 JVM이 사용했던 모든 메모리를 OS에 반납한다.
package com.eomcs.basic.ex07;

public class Exam04 {
}