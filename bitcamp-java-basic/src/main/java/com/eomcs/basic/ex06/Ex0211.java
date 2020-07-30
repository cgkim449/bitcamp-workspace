package com.eomcs.basic.ex06;

public class Ex0211 {

  public static void main(String[] args) {

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
    // 이게 리팩토링임 : 상수를 작성하는 것 등 주석이 없어도 한눈에 알아보게, 유지보수 쉽게
    System.out.println("----------------------------");

    switch (type) {
      case DEVELOPER:
        System.out.println("정보처리자격증");
      case GENERAL_MANAGER: // 여기서 시작해서 밑에있는 case들 무시하고 break만날때까지 실행한다
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

    String value = "hello";
    String value2 = "developer";

    switch (value) { // only convertible int values, strings, enum variables
      case "developer": // 변수는 안된다. 리터럴, 상수만 가능하다. 즉, 컴파일러가 바로 값을 알 수 있어야한다!
                // 변수는 변할 수 있으니까 다른 case랑 겹칠수있기때문에 컴파일러가 문제삼는다
        break;
      case value2:
        break;
      case "ok"+"haha":
      default:
    }

    int value3 =100;
    final int x = 200;
    switch (value3) {
      case 100:
        break;
      case 100+3:
        break;
      case x:
      case x+3: // 값이 변하지만 않으면 가능한것이다
    }

    System.out.println("-------------------------------");

    Job type2 = Job.DEV; // enum상수들을 저장하려는 변수를 만들자

    switch (type2) {
      case Job.DEV:
        break;
      case GM:
        break;
      case BM:
        break;
    }

  }

  enum Job{ // top-level class //enumeration // 상수에 값을 지정하는게 귀찮다, 변수값이 변하는게 위험하다
    DEV, GM, BM
  }
}