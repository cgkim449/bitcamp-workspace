// 1. Date, String 등: 사용자 정의 데이터 타입
// 사용자 정의 데이터 타입에 메서드를 정의하는 것은 그 데이터를 다룰 '연산자'를 정의하는 것이다

// 2. System, Socket 등: 메서드를 묶어놓기만 한 클래스

package com.eomcs.oop.ex02;

public class Exam01 {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    void calculate() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
    }
  }

  public static void main(String[] args) {

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 85;

    s.calculate(); // 변수 뒤에 연산자!!를 놓는 i++ 의 예와 비슷하다.
    // 훨씬 직관적이다
    System.out.printf("%s, %d, %d, %d, %d %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.average);
  }
}
