//#ex06 다형성 : 다형적 변수, 오버로딩, 오버라이딩
//
// - 다형적 변수 = 상위 클래스 레퍼런스 : '파라미터'로 쓰면 아주 유용하다
// - instanceof 연산자 : switch처럼 쓸수있다
//

//### 다형적 변수 : 물리적, 개념적으로 상위클래스가 하위 클래스를 가리킬 수 있다

// - 그 레퍼런스에 어떤 클래스의 객체를 담을 수 있느냐의 문제
// - 물리적, 개념적으로 상위 클래스는 하위 클래스를 가리킬 수 있다
// - 물리적, 개념적으로 하위 클래스는 상위 클래스를 가리킬 수 없다
// - 물리적, 개념적으로 형제, 사촌 클래스를 가리킬 수 없다
// - (Vehicle v = c // Vehicle아 Car을 가리켜라)
//
//### 레퍼런스의 형변환 : 단순주소값 + 설계((Sedan)) + 주소가 누구를 가리키는지

// - (중요) 상위 클래스 레퍼런스가 하위 클래스 인스턴스를 가리킬때 인스턴스 필드 전부에 접근할 수 없다
// - (단순 주소값이 아닌 주소값이 누구를 가리키는지, 설계) (Sedan)이 뭔가 정보를 담고있다
//   일단 단순 주소값은 가지고 있으니 그 정보만 추가해주면 된다
//   단순 주소값과 정보만 확인하면 컴파일러는 통과시킨다(컴파일러는 단순하다)
//   그 주소값이 누구를 가리키는지가 중요
// - 형변환한 변수 계속쓰는거 귀찮으니까 Sedan s = (Sedan)v1;
//
//### 다형적 변수가 필요한 이유 - 활용 : 파라미터로 상위 클래스 레퍼런스(즉 다형적 변수) 쓰면
//    메서드를 하나로 관리 가능

// - 차 종류(Sedan, Truck 등)이 5천개면 똑같은 코드로 5천개의 파라미터, 5천개의 메서드를 만들어야한다
// - Sedan, Truck등 그 차들의 공통된 속성인 Vehicle의 속성들을 출력하고 싶다
// - 그럼 코드가 같은 메서드를 파라미터와 메서드명이 다른채로 5천개 만들어야됨
// - 근데 그러지말고 Vehicle이 Sedan, Truck을 가리킬 수 있으니까 Vehicle을 파라미터로 쓰면
//   5천개 메서드를 하나로 줄일 수 있다는거다
// - 여기서 형변환 + instanceof + 제어문 사용하면 공통 속성인 Vehicle 속성뿐만 아니라
//   각각의 모든 속성을 출력할 수 있다
// - instanceof + if 로 case에 break없는 switch문처럼 만들 수 있다 가계도보면서 break 없애고 그러는거다
// - 결론 : "파라미터"로 "상위 클래스 레퍼런스"(즉 다형적 변수)를 쓰면 메서드를 하나로 만들어서
//         그 상위 클래스의 인스턴스 필드를 출력할 수 있다(다룰 수 있다)
//         + 형변환 + instanceof + 제어문 쓰면 각각의 모든 인스턴스 필드를 출력할 수 있다(다룰 수 있다)

package com.eomcs.oop.ex06.a;

public class PolymorphicVariableP {

  static void printCar(Car c) {
    if (c instanceof Car) {
      System.out.printf("%s, %d\n", c.model, c.cc);
      if (c instanceof Sedan) {
        System.out.printf("%b, %b\n", ((Sedan)c).auto, ((Sedan)c).);
      }
    }
  }

  public static void main(String[] args) {
    Sedan car1 = new Sedan();
    car1.model = "티코";
    car1.cc = 800;
    car1.auto = true;
    car1.sunroof = false;

    Truck car2 = new Truck();
    car2.model = "타이탄II";
    car2.cc = 10000;
    car2.ton = 3000f;
    car2.dump = true;

    printCar(car1);
    printCar(car2);
  }
}