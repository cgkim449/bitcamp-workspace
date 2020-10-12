// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
//파라미터 타입은 같은데 리턴타입이 다를때

// 재사용 = 호출!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 1 바디에 그냥 호출
// 2 return 호출;

// callee 메서드의 리턴값을 caller 메서드의 리턴값 

// 어디까지 가능한지
package com.eomcs.oop.ex12;


public class Exam0530 {

  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }
  }

  static interface Calculator1 {
    double compute(int a, int b);
  }

  static interface Calculator2 {
    float compute(int a, int b);
  }

  static interface Calculator3 {
    short compute(int a, int b);
  }

  static interface Calculator4 {
    void compute(int a, int b);
  }

  static interface Calculator5 {
    Object compute(int a, int b);
  }

  static interface Calculator6 {
    String compute(int a, int b);
  }

  public static void main(String[] args) {

    // 리턴 타입 int ===> double
    Calculator1 c1 = MyCalculator::plus; // OK!
    // 위문장은 다음 문장과 같다
    Calculator1 xx = new Calculator1() { // 얘를 생각해보고
      @Override
      public double compute(int a, int b) {
        return MyCalculator.plus(a, b); // 이 자리에 얘가 올수 있냐없냐만따지면 끝난다!
      }
    };
    System.out.println(c1.compute(100, 200));

    // 리턴 타입 int ===> float
    Calculator2 c2 = MyCalculator::plus; // OK!
    System.out.println(c2.compute(100, 200));

    // 리턴 타입 int ===> short
    //     Calculator3 c3 = MyCalculator::plus; // 컴파일 오류!

    // 리턴 타입 int ===> void
    Calculator4 c4 = MyCalculator::plus; // OK!
    Calculator4 c = new Calculator4() {
      @Override
      public void compute(int a, int b) { // 이 메서드안에 호출!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // 재사용한다 = 호출한다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        MyCalculator.plus(a, b);
      }
    };
    c4.compute(100, 200); // plus() 메서드의 리턴 값은 무시한다.

    // 리턴 타입 int ===> Object
    Calculator5 c5 = MyCalculator::plus; // OK!
    System.out.println(c5.compute(100, 200));
    // Integer.valueOf(100);

    // 리턴 타입 int ===> String
    // Calculator6 c6 = MyCalculator::plus; // 컴파일 오류!

    // => 메서드 레퍼런스를 지정할 때 리턴 타입의 규칙:
    // 1) 같은 리턴 타입
    // 2) 암시적 형변환 가능한 타입
    // 3) auto-boxing 가능한 타입
    // 4) void
    // 결론,
    // 메서드 레퍼런스가 가리키는 실제 메서드를 호출한 후
    // 그 메서드가 리턴한 값이
    // 인터페이스에 정의된 메서드의 리턴 값으로 사용할 수 있다면
    // 문제가 없다.
    //
  }
}
