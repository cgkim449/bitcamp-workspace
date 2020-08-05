package com.eomcs.basic.ex99;

//# 키보드 입력 받기 - 여러 개의 데이터를 한 번에 입력하고 쪼개서 읽기
//
public class Exam0250 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("나이, 이름, 취업여부? ");
    int age = keyboard.nextInt();

    // 한 개의 토큰을 읽을 때 유용하다, 리턴값은 반드시 문자열이다
    String name = keyboard.next();

// boolean working = keyboard.hasNextBoolean(); // '다음 불린값이 있느냐'
    // 그래서 false를 입력하면 true를 출력한다
    boolean working = keyboard.nextBoolean(); // 다음 불린값의 토큰을 읽어라

    keyboard.close();

    System.out.printf("%d, %s, %b\n", age, name, working);
  }
}















