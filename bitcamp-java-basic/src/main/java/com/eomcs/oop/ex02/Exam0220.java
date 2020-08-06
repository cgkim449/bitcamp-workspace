package com.eomcs.oop.ex02;

import com.eomcs.util.Calculator;

public class Exam0220 {
  public static void main(String[] args) {

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(3);
    c2.minus(1);
    c1.multiple(7);
    printResult(c1.result);
    printResult(c2.result);

  }
  static void printResult(int result) {
    System.out.println(result);
  }
}

// 함수는 걍 아규먼트를 받아서 리턴하거나 그런 기본적인 방식
// 근데 한계가 있었다 계산기 한대만 이용가능
// 1. 주소
// 2. 파라미터 개수!, 작업하는 방식을 파라미터로 받지않고 다른방식으로 하고 싶었다