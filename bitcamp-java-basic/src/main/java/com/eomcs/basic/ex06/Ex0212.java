package com.eomcs.basic.ex06;

public class Ex0212 {
  public static void main(String[] args) {

    Job type = Job.BUILDING_MANAGER;

    switch (type) {
      case DEVELOPER:
        System.out.println("정보처리자격증");
      case GENERAL_MANAGER:
        System.out.println("졸업증명서");
      case BUILDING_MANAGER:
        System.out.println("이력서");
        break;
      default:
        System.out.println("입력오류");
    }

    System.out.println("------------------------------");

    String value = "hello";
    String value2 = "developer";

    switch (value) {
      case value2:
        System.out.println();
      case "developer":
        System.out.println();
        break;
      case "ok"+"jaja":
        break;
    }


  }
  enum Job {
    DEVELOPER, GENERAL_MANAGER, BUILDING_MANAGER
  }
}