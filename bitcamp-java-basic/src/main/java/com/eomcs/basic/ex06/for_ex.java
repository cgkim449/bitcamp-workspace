package com.eomcs.basic.ex06;

public class for_ex {
  public static void main(String[] args) {
    for (;;) {
      // 1) 변수 초기화
      // 2) 조건
      // 3) 문장
      // 4) 변수증가문
      // 조건이 참인동안 2,3,4 반복
    }

    for (:) {

    }
    // 기본
    System.out.println("------------------------------------");

    for (int i = 0, k = 1, j = 2; i < 10; i++, j--, k += 2)
      System.out.println("(%d, %d, %d\n", i, j, k);

    System.out.println("------------------------------------");

    for (int i = 1; i <= 10; i++){
      for (int j = 1; j <= i; j++) {
        if (j % 2 == 0)
          continue; // 변수증가문으로 이동한다, 다른거는 조건문으로 이동
        System.out.println(j+"");
      }
      System.out.println();
    }

    System.out.println("------------------------------------");
  }
}
