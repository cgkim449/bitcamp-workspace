// 예외 처리 문법을 적용한 후 - 메서드가 던지는 예외 정보를 받는다.
package com.eomcs.exception.ex2;

public class Exam0110 {
  public static void main(String[] args) {
    String op = "#";
    int a = 100;
    int b = 200;

    try {
      // 예외를 던질 수도 있는 메서드를 호출할 때는 try 블록 안에서 호출한다.
      int result = Calculator3.compute(op, a, b);
      // 이거 실행했을때 예외 발생하면 바로 멈추고
      // 던진 객체 밑에서 e로 받아서
      // e.getMessage() 하면 메시지 리턴
      // (throw new ~(우리가 출력하고 싶은 메시지))
      System.out.println(result);

    } catch (RuntimeException e) {
      // try 블록 안에서 메서드를 호출하다가 예외가 발생하면
      // catch 블록에서 파라미터로 받는다.
      System.out.println(e.getMessage());
    }
  }
}


