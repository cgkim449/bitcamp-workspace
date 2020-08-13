// 배열 extends Object : println에서 toString() 자동으로

// getClass() : 클래스 정보
// getClass() 와 배열
// getClass() 와 배열의 항목 이름

package com.eomcs.corelib.ex01;

public class GetClassP {
  static class My {

  }

  public static void main(String[] args) {
    My obj1 = new My();

    Class<?> classInfo = obj1.getClass();

    System.out.println(classInfo.getName());
    System.out.println(classInfo.getName());
  }

}

