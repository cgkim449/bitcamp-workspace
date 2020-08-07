package com.eomcs.oop.ex03;

public class Exam0740 {
  public static void main(String[] args) {
    Object obj1 = new Object() {

      {
        System.out.println("인스턴스 블록");
      }
    };
  }

}
