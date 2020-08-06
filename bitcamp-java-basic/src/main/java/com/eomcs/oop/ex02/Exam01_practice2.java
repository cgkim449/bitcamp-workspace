package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.ScoreP2;

public class Exam01_practice2 {
  public static void main(String[] args) {
    ScoreP2 s1 = new ScoreP2("김", 100, 90, 97);
    printScore(s1); // call by value 변수가 아닌 값을 넘겨주는 것이다
  }

  static void printScore(ScoreP2 s) { // call by reference로 바꾸면 간결성, 기능성
    System.out.printf("%s : %d %d %d %d %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}