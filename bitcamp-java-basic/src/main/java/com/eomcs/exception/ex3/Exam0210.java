// Ex01 : 예외를 던지고 받자(throw, catch), 예외를 받지 않으면?
//  - 조건문써서 throw 많이 하는듯
// Ex02 : 발생가능한 예외를 '메서드 선언부에 선언'하여 호출자에게 알려주자!
// - 반드시! 선언해야한다
// - RuntimeException과 그 하위클래스들은 안해도 된다 스텔스 모드다
// - RuntimeException말고 Exception의 나머지 자식클래스들은 반드시 선언해야한다
// - Error는 스텔스 모드인거만 기억하자
// - Ex03 : 발생가능한 예외를 여러개 '메서드 선언부에 선언'할 수 있다
// Ex04 : catch
// - 나한테 예외 던져졌을 때 catch, throw 둘중에 하나 꼭해야됨(안하면 컴파일 오류)
//  - (RuntimeException은 여기서도 스텔스임)
//  - 내가 catch안하고 책임을 나를 호출하는 상위호출자에게 다시 떠넘기고싶다
//    => 내 선언부에서 또 throws
// - 여러 방법으로 catch할 수 있다(catch문이 여러개)
//  - 위 catch문부터 순서대로 캐치할수 있으면 캐치하고 못하면 밑으로 보냄
//  - 그래서 다형적 변수 조심해야되고
//  - 또는 다형적 변수를 잘 써먹을 수 도 있음
//  - 그리고 | 도 쓸 수 있음, 이건 catch문 만의 특별한 연산자임
//  - catch할때 Throwable을 변수로 사용하지 말라(당연)
// EX05 : 
package com.eomcs.exception.ex3;

import java.io.FileNotFoundException;

// Throwable의 자식 클래스
// 1. Error 클래스 : StackOverflow 클래스: 어쩔수없다 시스템을 멈춰야한다
// 2. Exception 클래스 : 우리가 시스템을 안멈추게 할 수 있다
public class Exam0210 {

  // throw 명령어를 사용하여 예외 정보를 호출자에게 던진다.
  // => throw [java.lang.Throwable 타입의 객체];
  //
  // java.lang.Throwable
  // => Throwable에는 두 부류의 서브 클래스가 있다.
  // 1) java.lang.Error (시스템 오류)
  // => JVM에서 발생된 오류이다.
  // => 개발자가 사용하는 클래스가 아니다.
  // => 이 오류가 발생하면 현재의 시스템 상태를 즉시 백업하고, 실행을 멈춰야 한다.
  // => JVM에서 오류가 발생한 경우에는 계속 실행해봐야 소용이 없다.
  // 근본적으로 문제를 해결할 수 없다.
  // => 오류의 예:
  // 스택 오버 플로우 오류, VM 관련 오류, AWT 윈도우 관련 오류, 스레드 종료 오류 등
  //
  // 2) java.lang.Exception (애플리케이션 오류)
  // => 애플리케이션에서 발생시킨 오류이다.
  // => 개발자가 사용하는 클래스이다.
  // => 적절한 조치를 취한 후 계속 시스템을 실행하게 만들 수 있다.
  // => 오류의 예:
  // 배열의 인덱스가 무효한 오류, I/O 오류, SQL 오류, Parse 오류, 데이터 포맷 오류 등
  //

  // 오류를 던진다면 반드시!! 메서드 선언부에 어떤 오류를 던지는지 선언해야 한다.
  // => 메서드 호출자에게 알려주는 것이다.

  // 아까 선언 안했는데?
  // 기다려라
  // 기본은 반드시 선언!
  static void m1() throws Throwable {
    throw new Throwable(); // OK!
    // 예외를 던질 때 Throwable 클래스를 직접 사용하지 말라!
    // 그 하위 클래스를 사용하라.(Error, Exception 두개 있는데 Exception을 사용)
    // 특히 애플리케이션 오류를 의미하는 Exception 클래스를 사용하라.
  }

  // 여러 개의 오류를 던지는 경우 메서드 선언부에 그대로 나열하라.
  static void m2() throws FileNotFoundException, RuntimeException {
    int a = 100;
    if (a < 0)
      throw new FileNotFoundException(); // OK!
    else
      throw new RuntimeException(); // OK!
  }

  public static void main(String[] args) {}

}
