// 프로그래밍을 하다가 로컬 클래스를 만나면, 중첩인터페이스를 구현하고, 정의하고 생성했는지 보자, 이게 로컬클래스를 보고 제일 먼저 할일
// 그다음에 한번만 생성했는지 보자, 그럼 익명 클래스
// 그다음에 funtional interface인지 보자, 그럼 람다
// 03 아규먼트에 람다 활용
// 04 리턴 문장!에 람다(lambda) 활용


// 이전 예제와 다른점은 생성자가 필요하다는 것
// 그래서 인스턴스 블록을 사용
// 근데 안쓰고 걍

// 중첩클래스 안에서 바깥클래스의 로컬변수에 접근(final or 준하는) 이번예제 핵심!
//
// 인스턴스 변수 선언하고 생성자 
// 그데 굳이 생성자로 받을 필요가 없어 왜냐면 final준하는 거 접근할수있거든
// 그래서 지워버려

package com.eomcs.oop.ex12;

public class Exam0410 {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {
    // 로컬 클래스로 인터페이스 구현한 후 객체 리턴하기
    class InterestImpl implements Interest {
      double rate;

      public InterestImpl(double rate) {
        this.rate = rate;
      }

      @Override
      public double compute(int money) {
        return money + (money * rate / 100);
      }
    }
    return new InterestImpl(rate);
  }

  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("금액: %.2f\n", i1.compute(1_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("금액: %.2f\n", i2.compute(1_0000_0000));
  }

}


