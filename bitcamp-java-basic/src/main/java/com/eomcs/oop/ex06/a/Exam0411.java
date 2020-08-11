// 다형성 - 다형적 변수의 활용 : 다형적 변수가 필요한 이유

// model과 cc는 Sedan과 Truck이 모두 가지고 있는 필드이다
// 그런데 그 둘만 사용하는 메서드이여도 Truck레퍼런스를 그 메서드에 전달할 수 없는것.
// 그래서 중복코드지만 새 Truck을 위한 메서드를 만들어줘야한다
// 우리는 이 메서드를 두개가 아닌 하나로 만들고 싶다!
// 그래서 이때 다형적 변수가 필요한거다

package com.eomcs.oop.ex06.a;

public class Exam0411 {

  // Sedan과 Truck의 모델명과 cc를 출력하라!

  public static void printSedan(Sedan sedan) {
    System.out.printf("모델명: %s\n", sedan.model);
    System.out.printf("cc: %d\n", sedan.cc);
    System.out.println("-------------------------");
  }

  public static void main(String[] args) {
    Sedan car1 = new Sedan();
    car1.model = "티코";
    car1.cc = 800;

    Truck car2 = new Truck();
    car2.model = "타이탄II";
    car2.cc = 10000;

    printSedan(car1);

    // printSedan()의 파라미터는 Sedan 객체의 주소만 받을 수 있다., 자식도 받을수잇다
    // 그래서 Truck 객체를 전달할 수 없다.
    printSedan(car2); // 컴파일 오류!

    // Truck 인스턴스에서 model과 cc 값을 꺼내서 출력할 메서드를
    // 따로 만들어야 한다.

  }

}




