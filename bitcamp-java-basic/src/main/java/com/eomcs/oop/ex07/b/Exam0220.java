// 캡슐화(encapsulation) - 응용
// new가 좀 위험한가 왜 직접 인스턴스 생성하는 걸 막지
// 직접 인스턴스를 생성하면 안좋은게 있나
//
// 직접 인스턴스를 생성하면 '너무 복잡하니까' 개발자가 실수할수 있다?
// (김밥을 잘 못만드니까 김밥집에 김밥을 만들어달라고 한다)
// 다른 메서드를 통해 인스턴스를 생성하라


package com.eomcs.oop.ex07.b;

import com.eomcs.oop.ex07.b.sub.C;

public class Exam0220 extends C {

  public static void main(String[] args) {

    //Car c1 = new Car(); // 컴파일 오류!
    // 생성자가 private이기 때문에 다른 클래스에서 호출할 수 없다.
    // 따라서 인스턴스를 생성할 수 없다.
    //
    // 그럼 왜 생성자를 private으로 만들었는가?
    // => 개발자가 직접 인스턴스를 생성하면 너무 복잡하니,
    //    다른 메서드를 통해 인스턴스를 생성하라는 의미다!
    Car c2 = Car.create("티코");
//    Car c2 = new Car("티코");
    System.out.printf("%s,%s,%d,%d\n",
        c2.model, c2.maker, c2.cc, c2.valve);

  }
}







