// 다형성 - 다형적 변수의 활용 : 다형적 변수가 필요한 이유
// 즉 같은 부모 클래스를 가지고 있는 하위 클래스들에 대한 메서드를 한개로 만들 수 있다

// 이 예의 메서드에서는 Sedan과 Truck이 공통으로 가지고 있는게 Car의 인스턴스 필드들임
// 그래서 파라미터를 Car car로 해서 Sedan 레퍼런스, Truck 레퍼런스 둘다 받을 수 있게 한거임

package com.eomcs.oop.ex06.a;

public class Exam0413 {

  // Sedan과 Truck의 모델명과 cc를 출력하라!

  // 다형적 변수를 사용하게 되면 동일한 코드를 갖고 있는 메서드를
  // 한 개의 메서드로 통합할 수 있다.
  // => 즉 Sedan 객체와 Truck 객체를 모두 가리킬 수 있는
  //    상위 클래스의 레퍼런스를 선언하면 된다.
  //
  public static void printCar(Car car) { // 형태가 여러개다
    System.out.printf("모델명: %s\n", car.model);
    System.out.printf("cc: %d\n", car.cc);
    System.out.println("-------------------------");
  }

  public static void main(String[] args) {
    Sedan car1 = new Sedan();
    car1.model = "티코";
    car1.cc = 800;

    Truck car2 = new Truck();
    car2.model = "타이탄II";
    car2.cc = 10000;

    // 또다른 해결책?
    // Sedan과 Truck을 모두 처리하는 메서드를 만들어 사용하라!
    printCar(car1); // OK! 왜? Sedan은 Car의 일종이다.
    printCar(car2); // OK! 왜? Truck도 Car의 서브클래스이다.

  }

}




