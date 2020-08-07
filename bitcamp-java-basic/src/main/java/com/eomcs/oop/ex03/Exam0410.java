// # 핸드폰 초기설정인데 하라는 설정(볼륨,밝기 등)은 안하고 엉뚱한걸(화면에 출력) 할 수 있다
//
// 설명 : 
// 생성자는 메서드라는걸 잊지말자

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
