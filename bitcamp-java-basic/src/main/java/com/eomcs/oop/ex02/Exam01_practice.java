package com.eomcs.oop.ex02;

public class Exam01_practice {

  String name = "홍길동";
  int kor = 100;
  int eng = 90;
  int math = 94;
  int sum;
  float aver;

  public static void main(String[] args) {
    Exam01_practice e = new Exam01_practice();
    e.computeScore();
    e.printScore();
  }

  void computeScore() {
    this.sum = this.kor + this.math + this.eng;
    this.aver = this.sum / 3f;
  }

  void printScore() {
    System.out.printf("%s : %d %d %d %d %.1f",
        this.name, this.kor, this.eng, this.math, this.sum, this.aver);
  }

}