// 스태틱 초기화 블록(static initializer) - 레퍼런스 선언
// - 단순히 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다
// - 여러개의 스태틱 초기화 블록, 스태틱 초기화 문장이 있을때 컴파일러가 하나로 합친다

package com.eomcs.oop.ex03eom;

public class Exam0610 {
  public static class A {
    static int a;

    static void m() {}

    static {

    }
  }
}
