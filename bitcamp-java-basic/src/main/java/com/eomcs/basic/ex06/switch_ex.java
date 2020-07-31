package com.eomcs.basic.ex06;

public class switch_ex {

  enum Job{ // top-level class //enumeration
            // 변수값이 변하는게 위험하다, 상수에 값을 지정하는게 귀찮다
    DEV, GM, BM
  }

  public static void main(String[] args) {

    String value = "hello";
    String value2 = "developer";
    int value3 =100;

    int x;
    int v=3;

    switch (4) { //  4바이트이하정수, 문자열, 특별한 상수 Enum타입만 가능
                 // (only convertible int values, strings, enum variables)
      case 3:
        break;
      case v: // case값으로 변수를 사용할 수 없다. 변하지만 않는 값만 쓸 수 있다.
              // 즉, 리터럴, 상수만 가능하다. 컴파일러가 바로 값을 알 수 있어야한다!
              // 변수는 변할 수 있으니까 다른 case랑 겹칠수도있기때문에 컴파일러가 문제삼는다
        break;
      case value2:
        break;
      case "ok"+"haha":
      case 100+3:
        break;
      case x:
      case x+3:
      default:
        break;
    }
    switch ('A') {
      case 0x43:
      case 'A':
      case '\u0041':
    }
    switch ("김찬구") {
    }
    switch (value3) {
    }

    Job type2 = Job.DEV;

    switch (type2) {
      case Job.DEV:
        break;
      case GM:
        break;
      case BM:
        break;
    }
    //기본

    System.out.println("-------------------------------");
    final int DEVELOPER = 1;
    final int GENERAL_MANAGER = 2;
    final int BUILDING_MANAGER = 3;

    int type = 4;

    switch (type) {
      case DEVELOPER:
        System.out.println("정보처리자격증");
      case GENERAL_MANAGER:
        System.out.println("졸업증명서");
      case BUILDING_MANAGER:
        System.out.println("이력서");
        break;
      default:
        System.out.println("잘못된 지원입니다");
    }
    // 이게 리팩토링이다 : 상수를 작성하는 것 등 주석이 없어도 한눈에 알아보게, 유지보수 쉽게
    System.out.println("-------------------------------");

    switch (type) {
      case DEVELOPER:
        System.out.println("정보처리자격증");
      case GENERAL_MANAGER: // 여기로 와서 밑에있는 case들 무시하고 break만날때까지 실행한다
        System.out.println("졸업증명서");
      case BUILDING_MANAGER:
        break;
      default:
        System.out.println("잘못된 지원입니다");
    }

    System.out.println("-------------------------------");

    int score = 70;

    switch (score) {
      case 100:
      case 90:
        System.out.println("A");
        break;
      case 80:
      case 70:
        System.out.println("B");
        break;
      case 60:
      case 50:
        System.out.println("C");
        break;
      default:
        System.out.println("D");
    }
// 범위를 검사할때는 if를 써라, 값이 딱딱 떨어지면 switch

    System.out.println("----------------------------------");


  }
}