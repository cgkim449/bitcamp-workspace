// 다형성 - 다형적 변수(polymorphic variables) - 레퍼런스의 type casting
// 중요
// 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬 때 인스턴스 필드 전부에 갈 수 없다

// 애초에 선언될때 그렇게 설계(Car c)되어있다 상위클래스의 인스턴스 필드까지만 갈 수 있다는 설계
// 그 접근하게 할 수 있는 '설계'가 필요하다 (Sedan), 그것을 cast라고 하는듯
// 일단 주소값은 가지고 있으니까 그 설계만 추가해주면된다
// cast : 설계를 주는 것
//
// 분명히 주소값은 c에 있음,
// 근데 당연히 주소값만으로는 안된다
// (Sedan)이 뭔가 정보를 담고있는듯, 인스턴스 필드에 접근할 수 있게한다던가
// 애초에 Sedan s 이렇게 선언할때 Sedan에 정보가 있는거다
// Sedan 인스턴스에 있는 연속된 인스턴스 필드들에 접근할 수 있게하는
package com.eomcs.oop.ex06.a;

public class Exam0115 {

  public static void main(String[] args) {

    // 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬 때
    Car c = new Sedan();

    c.model = "티코"; // Vehicle의 인스턴스 변수
    c.capacity = 5;  // Vehicle의 인스턴스 변수
    c.cc = 890;      // Car의 인스턴스 변수
    c.valve = 16;    // Car의 인스턴스 변수

    // 레퍼런스가 실제 하위 인스턴스를 가리키고 있다 하더라도,
    // 레퍼런스 타입의 범위를 벗어나서 사용할 수 없다.
//    c.sunroof = true; // 컴파일 오류!
//    c.auto = true;    // 컴파일 오류!

    // 왜?
    // => 자바 컴파일러는 레퍼런스가 실제 어떤 인스턴스를 가리키는지 따지지 않고
    //    레퍼런스의 타입에 한정하여 인스턴스나 클래스의 멤버 사용을 허락한다.

    // 해결책?
    // => 레퍼런스 변수가 실제 가리키는 것이 무엇인지 알려줘야 한다.
    // => ((원래인스턴스타입) 레퍼런스).멤버
    ((Sedan)c).sunroof = true; // OK!
    ((Sedan)c).auto = true;    // OK!

    // => 또는 인스턴스의 원래 클래스 레퍼런스에 저장한 다음에 사용.
    Sedan s = (Sedan)c; // c에는 이미 어느 필드까지만 갈 수 있다는 정보가 있는 것이다
    // Car의 필드에만 갈 수 있다는
    s.sunroof = true;
    s.auto = true;
  }

}










