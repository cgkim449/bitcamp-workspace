package com.eomcs.basic.ex07;

import java.util.ArrayList;

public class Exam0413 {
  public static void main(String[] args) throws Exception{
    ArrayList list = new ArrayList();

    while (true) {
      list.add(creatArray());
      Thread.currentThread().sleep(2000);
    }
  }

  static int[] creatArray() {
    System.out.println(".");
    return new int[10_000_000];
  }
}
// 에러의 종류 두가지
// exception: 개발자가 작성한 명령어땜에 생기는 에러, 개발자가 통제 가능함
// error :  JVM에서 생기는 에러, 개발자가 통제할 수 없다(예: OutOfMemoryError : Java heap space)