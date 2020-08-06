package com.eomcs.oop.ex02.util;

public class Score4 {
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public void compute() { // 데이터들을 가공하다, operate, 연산자
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
// 생성자를 만들자 // 특이하게 만듬
  public Score4(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }
}