package com.eomcs.exception.ex3;

public class Exam0111p {

  static void m() {
    throw new RuntimeException("예외발생!");
  }

  public static void main(String[] args) {

    m();
    System.out.println("시스템을 종료합니다.");
  }
}
