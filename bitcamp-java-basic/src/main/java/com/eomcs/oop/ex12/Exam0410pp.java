// 리턴 문장에 람다(lambda) 활용


// 이전 예제와 다른점은 생성자가 필요하다는 것
// 그래서 인스턴스 블록을 사용
// 근데 안쓰고 걍

// 중첩클래스 안에서 바깥클래스의 로컬변수에 접근(final or 준하는) 이번예제 핵심!
//
// 인스턴스 변수 선언하고 생성자 
// 그데 굳이 생성자로 받을 필요가 없어 왜냐면 final준하는 거 접근할수있거든
// 그래서 지워버려

package com.eomcs.oop.ex12;

public class Exam0410pp {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {

    class InterestImpl implements Interest {
      //      double rate; // 인스턴스 변수 딱 파악하자
      //
      //      public InterestImpl(double rate) { // 생성자 딱 파악하자
      //        this.rate = rate;
      //      }

      @Override
      public double compute(int money) {
        return money + (money * rate / 100); // 위에 코드들이 없다고 생각하자, 그럼 rate라고 했을때
        // 중첩클래스는 this가 생략되면 점점 바깥으로 나가면서 변수를 찾는다
        // 근데 보니까 메서드에 로컬 변수가 있네 그거도 final에 준하는
        // (중첩클래스는 조회용으로만?)
        // 우리가 위에서 인스턴스 필드, 그리고 그걸 생성자로 주입받는거
        // 이 코드를 쓴 이유는 rate가 필요하기 때문이다(필드 주입!!)
        // 근데 저게 필요없는거지 저거들 가리고 이 메서드만 보면

      }
    }
    return new InterestImpl();
  }

  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("금액: %.2f\n", i1.compute(1_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("금액: %.2f\n", i2.compute(1_0000_0000));
  }

}


