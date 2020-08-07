// # 특별한 인스턴스 메서드 - 생성
// # 핸드폰 초기설정인데 설정(볼륨,밝기 등)도하고 출력도 할수있고 소리도 낼수있음
//
// 설명 :
// 생성자도 인스턴스 메서드라는걸 잊지말자

// # 생성자
// - 비유 : 핸드폰 초기설정




package com.eomcs.oop.ex03;

public class Exam0410 {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    public Score() {
      System.out.println("Score()");
    }

    public void compute() {
      sum = kor + eng + math;
      average = sum / 3f;
    }
  }
  public static void main(String[] args) {

    Score s1 = new Score();
    Score s3 = new Score();
  }
}
