package com.eomcs.oop.ex02;
//그냥 단순하다 관련이 있는 변수, 메서드들을 묶어서 관리

import com.eomcs.oop.ex02.util.Score4;

public class Exam0119 {

  public static void main(String[] args) {

    Score4 s1;
    s1 = new Score4("홍길동", 100, 90, 87); // static이 붙은 변수는 안만든다, 따로 관리
    Score4 s2 = new Score4("임꺽정", 90, 100, 100);

    printScore(s1);
    System.out.println("-------------------");
    printScore(s2);

    System.out.println("-------------------");
    s1.kor = 50; // 이렇게 항목 값을 바꿀수 있기 때문에 compute는 내버려 둔다
    s1.compute();
    printScore(s1);
  }

  static void printScore(Score4 s) { // 프린트 방식이 바뀔 수 있기때문에 여기 둔다
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}