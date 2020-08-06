package com.eomcs.oop.ex02;

public class Exam01_practice3 {
  static class Score {
    String name;
    int kor;
    int math;
    int eng;
    int sum;
    float aver;
    
    Score(String name, int kor, int math, int eng) {
      this.name = name;
      this.kor = kor;
      this.math = math;
      this.eng = eng;
      
      this.compute();
    }
    
    void compute() {
      sum = kor + math + eng;
      aver = sum / 3f;
    }
  }
  public static void main(String[] args) {
    Score scores = new Score("giorno", 98, 100, 95);
    printScore(scores);
  }
  
  static void printScore(Score scores) {
    System.out.printf("%s %d %d %d %d %.1f\n",
        scores.name, scores.kor, scores.math, scores.eng, scores.sum, scores.aver);
  }
}