// 예외 처리 후 마무리 작업 - finally 블록
// finally는 무조건!!! 실행(예외(Exception)가 생기든 말든 에러(Error)가 생기든 말든)
// 1. 즉 정상적으로 실행하여 catch문을 실행안해도 try문을 나가기전에 반드시 실행
// 2. 예외가 발생하면 catch문을 나가기전에 반드시 실행
// 3. main이 catch 안하고 또 throw해서 JVM이 Exception 받아도 반드시 실행
// (이때는 try{} finally{}로 해야 finally 실행할수 있다)
// 그래서 finally문에는 'try 에서 사용한 자원을 해제시키는 코드'를 주로 둔다.
// => '자원 해제 코드'를 둔다.

// 자원을 해제하려는데
// 문제는 close()를 호출하기 전에 예외가 발생한다면,
// 제대로 자원을 해제시키지도 못한다는 것이다.
// 이것을 해결하기 위해 finally 블록을 사용하는 것이다.

package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0510 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
  }

  public static void main(String[] args) {
    try {
      m(0);
      System.out.println("try");

    } catch (RuntimeException | SQLException | IOException e) {
      System.out.println("catch 1");

    } catch (Exception e) {
      System.out.println("catch 2");

    } finally {
      // '정상적으로 실행하든', 아니면 '예외가 발생하여 catch 블록을 실행하든'
      // finally 블록은 무조건 실행한다.
      // 즉 try ~ catch ~ 블록을 나가기 전에 반드시 실행한다.
      // 그래서 이 블록에는
      // 'try 에서 사용한 자원'을 해제시키는 코드를 주로 둔다.
      // => '자원 해제 코드'를 둔다.
      // => 자원? 파일, DB 커넥션, 소켓 커넥션, 대량의 메모리 등
      // 파일을 열었으면 닫아야한다
      // 썼으면 닫아줘야한다
      System.out.println("finally");
    }
  }

}
