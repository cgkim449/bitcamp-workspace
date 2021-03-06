// 예외 처리 후 마무리 작업 - try-with-resources
package com.eomcs.exception.ex3;

public class Exam0640p {

  static class A {
  }

  static class B {// 걍 만든 close()있고, AutoCloseable의 규칙에 따라 만들었다고 선언하지 않음
    public void close() throws Exception {
      System.out.println("B 클래스의 자원을 해제하였습니다.");
    }

    static class C implements AutoCloseable {
      @Override // close()를 AutoCloseable 규칙에 따라 만들었고, 그걸 선언함
      public void close() throws Exception {
        System.out.println("C 클래스의 자원을 해제하였습니다.");
      }
    }

    public static void main(String[] args) throws Exception {

      try (
          // A 클래스는 AutoCloseable 구현체가 아니기 때문에 여기에 선언할 수 없다.
          // A obj = new A(); // 컴파일 오류!

          // B obj2 = new B(); // OK!
          C obj3 = new C(); // OK!
          ) {
        System.out.println("try 블록 실행...");
      }
      // finally 블록에서 B의 close()를 호출하지 않아도,
      // 자동으로 호출될 것이다. 실행하여 확인하라!
    }
  }
}
