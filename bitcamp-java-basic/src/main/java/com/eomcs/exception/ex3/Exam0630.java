// 예외 처리 후 마무리 작업 - try-with-resources(finally 귀찮으니까 이거쓰자)

// finally는 try catch문을 나가기전에 반드시 실행된다
// 그래서 try에서 사용한 자원을 해제하는 코드를 finally에 넣는 용도로 주로 사용한다
// close()를 호출하기전에 예외가 발생하면 close()를 못하니까 말이다
// 이처럼 try에서 뭔가 하고 그에 따라 뭔가를 반드시 해줘야할 때 finally를 사용하는것이다
// 
// 근데 finally 쓰는게 귀찮네
// 그래서 try () 문법 탄생
// ()안에 try에서 쓸 자원을 넣는다
// 그럼 finally가 없어도 try catch를 나갈때 close()를 자동으로 호출
// 그래서 close()가 있는 그런 변수만 선언 가능
// 근데 어느 클래스가 close()있는지 없는지 어떻게 아냐
// 그래서 규칙을 정의를 한다(AutoCloseable에 close()있음)
// AutoCloseable 구현체는 close()를 반드시 가진다
// 그래서 괄호 안에 들어갈수 있는 클래스는 AutoCloseable 구현체 뿐
// 괄호안에는 자원만 넣을 수 있다 그중에서도 AutoCloseable을 구현안한 자원은 들어갈수 없다

// try에서 사용해야하는 객체 그리고 그 객체는 그걸 쓰고 나면 반드시 뭔가를 해야하는 특징이있음
// 그때이용하는것이 finally, try-with-resources
package com.eomcs.exception.ex3;

import java.io.FileReader;
import java.util.Scanner;

public class Exam0630 {

  static void m() throws Exception {
    // 자원해제시키는 코드를 매번 작성하기가 귀찮다!
    // => try-with-resources 라는 문법을 사용하면
    // 굳이 finally 블록에서 close()를 직접 호출할 필요가 없다.
    // 자동으로 처리한다.
    // => 단 java.lang.AutoCloseable 구현체에 대해서만 가능하다!
    // => 문법
    // try (java.lang.AutoCloseable 구현체) {...}

    try (Scanner keyScan = new Scanner(System.in); // OK!

        // FileReader 클래스도 java.lang.AutoCloseable 구현체이다.
        FileReader in = new FileReader("Hello.java"); // OK!

        // 반드시 AutoCloseable 구현체이어야 한다.
        // String s = "Hello"; // 컴파일 오류!

        // 변수 선언만 올 수 있다.
        // if (true) {} // 컴파일 오류!

        ) {
      System.out.print("입력> ");
      int value = keyScan.nextInt();
      System.out.println(value * value);
    }
  }

  public static void main(String[] args) throws Exception {
    m();
  }

}
