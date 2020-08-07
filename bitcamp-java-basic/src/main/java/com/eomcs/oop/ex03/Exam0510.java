// # 변수 자동 초기화 - 스태틱 변수
// # 스태틱 변수, 인스턴스 변수는 자동으로 초기화된다, 로컬변수는 그렇지 않다
// 스태틱 변수 = 클래스 변수이며 로컬변수는 메서드 안에서 선언된 변수를 말한다
// 즉 클래스 안에서 선언된 스태틱 변수, 인스턴스 변수는 자동초기화되는데
//메서드 안에서 선언된 로컬변수는 자동초기화가 안된다
package com.eomcs.oop.ex03;

import java.sql.Date;

public class Exam0510 {
  static class A {
    static byte b;
    static short s;
    static int i;
    static long l;
    static char c;
    static float f;
    static double d;
    static boolean bool;
    static String str;
    static Date date;
  }

  public static void main(String[] args) {

    // 클래스 변수(스태틱 변수)는 생성되는 순간 0으로 자동 초기화 된다.
    // => 정수(byte, short, int, long, char) : 0
    // => 부동소수점(float, double) : 0.0 = 0
    // => 논리(boolean) : false = 0
    // => 레퍼런스: null = 0
    //
    System.out.printf("%d, %d, %d, %d, %c, %.1f, %.1f, %b, %s, %s\n", A.b, A.s, A.i, A.l, A.c, A.f,
        A.d, A.bool, A.str, A.date);
  }
}


