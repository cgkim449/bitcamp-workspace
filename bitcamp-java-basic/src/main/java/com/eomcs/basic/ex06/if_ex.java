package com.eomcs.basic.ex06;

public class if_ex {
  public static void main(String[] args) {

    if (true) System.out.println("1111");
    if (false) System.out.println("2222");

    boolean b;
    if (b = true) System.out.println("된다!");

    //기본

    System.out.println("------------------------------------");

    int age2 = 17;

    if (age2 >= 19)
      if (age2 >= 65)
        System.out.println("지하철 무임승차 가능합니다");
    else
        System.out.println("미성년입니다");
      else
      System.out.println("ok");

    //else는 가장가까운 if와 함께 한문장!

    System.out.println("-------------------------------------");

    int age3 = 5;

    if (age3 < 8)
      System.out.println("아동!");
    else
      if (age3 < 14)
        System.out.println("어린이");
      else
        if (age3 < 19)
          System.out.println("청소년");
        else
          if (age3 < 65)
            System.out.println("성인!");
          else
            System.out.println("노인!");

    // 정석

    age3 = 16;

    if (age3 < 8) {
      System.out.println("아동!");
    } else if (age3 < 14) {
      System.out.println("어린이");
    } else if (age3 < 19) {
      System.out.println("청소년");
    } else if (age3 < 65) {
      System.out.println("성인!");
    } else {
      System.out.println("노인!");
    }

    //else if라는 문법은 없다! 걍 정렬한것 // vbscript는 else if 문법 존재함

  }
}