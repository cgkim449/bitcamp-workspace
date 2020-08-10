package com.eomcs.oop.ex04;

import java.util.Calendar;
import java.util.Date;

public class Exam01 {
  public static void main(String[] args) throws Exception {

    String s1 = new String(); // 빈문자열, null아님 // String클래스의 기본생성자
    System.out.println("=>" + s1); // 문자열 + 주소?

    String s2 = new String("Hello"); // String 클래스의 리터럴을 받는 생성자
    System.out.println("=>" + s2); // 문자열 + 주소?

    char[] chars = new char[] { 'H','e','l','l','o','2','!'};
    String  s3= new String(chars); // char배열을 받는 생성자를 받아서 인스턴스를 초기화시키는 생성자
    System.out.println("=>" + s3); // 문자열 + 주소?

    //-128(1000 0000)~127(0111 1111)
    byte[] bytes = new byte[] {
        0x41, // A ==> 0041 "UTF-8"을 주면 2바이트 0041로 바뀜
        0x42, // B ==> 0042
        (byte)0xEA, // 가 ==> AC00
        //양수로 취급되는 순간 앞에 0들이 붙는다 00000000 00000000 00000000 11101010 그래서 byte로 형변환해야
        (byte)0xB0,
        (byte)0x80, // "UTF-8"를 주면 3개를 묶어서 2바이트로 바꾼다 AC00으로
        (byte)0xEA,
        (byte)0xB0,
        (byte)0x81, // 각 ==>
    };

    String  s4 = new String(bytes, "UTF-8"); // byte가 utf-8다 주면 규칙에 따라 역으로 유니코드로바꿈
    System.out.println("=>" + s4);
//utf-8을 utf-16으로

    byte[] bytes2 = new byte[] {
        0x41, // A ==> 0041
        0x42, // B ==> 0042
        (byte)0xB0,
        (byte)0xA1, // 가
        (byte)0xB0,
        (byte)0xA2, // 각
        (byte)0xB6,
        (byte)0xCA, // 똘(EUC-KR)
        (byte)0x8C,
        (byte)0x63, // 똠(MS949/CP949)
        (byte)0xB6,
        (byte)0xCB // 똥(EUC-KR)
    };

    String  s5 = new String(bytes2, "MS949"); // MS949(11172자) = EUC-KR(2350자) + a
    System.out.println("=>" + s5);
//euc-kr을 utf-16으로

// 파일로 받든 네트워크로 받든 보통 바이트 배열로 받는다 그걸 utf-16으로 바꿔야한다
    // 그랬을때 저쪽에서 어떤 규칙으로 한글을 썼는지 알아야한다

    Date d1 = new Date(); // 실행하는 시점의 날짜,시분초로 초기화
    System.out.println(d1.toString());
    System.out.println(d1); // d1.toString()
    // 아규먼트가 primitive type이나 String타입이 아니면
    // 인스턴스에 대해 toString()을 호출하여 그 리턴값을 출력한다
    // 자바의 모든 클래스나 배열에 대해서 toString()을 호출할 수 있다

    int[] arr = new int[] {100, 200, 300};
    System.out.println(arr); // .toString() int배열골뱅이해쉬코드(고유값) 주소값이 아니다

    int a = 100;
    System.out.println(a);

    Date d2 = new Date(100000); // 1970-1-1부터 1분 40초가 지났다
    System.out.println(d2);

    Date d3 = new Date(120, 8, 10);
    System.out.println(d3);

    // 클래스 중에서는 생성자를 공개하지 않은 경우가 있다
    // 이런 클래스의 인스턴스를 만들려면 보통 다음 2가지 방법을 사용한다
    // 1) 다른 클래스의 도움을 받는다
    // 2) 해당 클래스에서 제공하는 클래스 메서드를 사용한다
 //   Calendar c1 = new Calendar();
    Calendar c1 = Calendar.getInstance(); // 똑같은 인스턴스를 계속 만드는걸 막고싶어서 생성자를 막아놓음
    System.out.println(c1); // toString()

    Car car1 = new Car();
    Car car2 = new Car();
    System.out.println(car1 == car2);
    car1.model = "티코";
    car1.cc = 980;
    car2.model = "소나타";
    car2.cc = 1980;
    System.out.println(car1.model);
    System.out.println(car2.model);

//    Car2 car3 = new Car2();
    Car2 car3 = Car2.getInstance();
    Car2 car4 = Car2.getInstance();

    System.out.println(car3 == car4); // 같다!
    car3.model = "비트카";
    System.out.println(car4.model);
  }

}

class Car { // package member class
  String model;
  int cc;
}

class Car2 {
  String model;
  int cc;
  static Car2 obj;

  private Car2() {} // 같은 클래스 안에서만!호출가능

  static Car2 getInstance() {
    // 보통 생성자를 private으로 막는 경우는
    // 인스턴스를 한개만 생성하도록 제한하고 싶을 때 이다
    if (obj == null) {
      obj = new Car2();
    }
    return obj;
  }
}