// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
// 우리는 초보라서 '어떤상황에' 메서드 레퍼런스를 써야할지 감이안온다
// 그래서 남이 이렇게 썼을때 최소한 알아봐야하니까 배우는것
// 이 문법은 난해하다
// 한두달만 지나면 감이온다

// 기존에 만든 코드를 재사용!했으면 해서 등장한 문법
// 람다를 만들건데
// 기존에 갖고있던 이름만 빼놓고 메서드의 시그너처가 같아!
// 이럴때 사용

package com.eomcs.oop.ex12;


public class Exam0510 {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  static interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {
    // 메서드 한 개짜리 인터페이스의 구현체를 만들 때
    // 기존 스태틱 메서드를 람다 구현체로 사용할 수 있다.
    // => 단 인터페이스에 선언된 메서드의 규격과 일치해야 한다.
    // => 규격? 파라미터 타입 및 개수, 리턴 타입
    // => 문법:
    //    클래스명::메서드명
    Calculator c1 = MyCalculator::plus;
    Calculator c2 = MyCalculator::minus;
    Calculator c3 = MyCalculator::multiple;
    Calculator c4 = MyCalculator::divide;

    System.out.println(c1.compute(200, 17)); // compute() ==> plus()
    System.out.println(c2.compute(200, 17)); // compute() ==> minus()
    System.out.println(c3.compute(200, 17)); // compute() ==> multiple()
    System.out.println(c4.compute(200, 17)); // compute() ==> divide()
  }
}


