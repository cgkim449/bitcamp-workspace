// # 생성자 당위성 : Score s = new Score("giorno", 100, 90, 70); 
// 배열처럼 이렇게 선언 동시에 정의하고 싶어서
//
// 설명 : 
// 일일히 인스턴스변수에 값넣는거 너무 귀찮아서 init() 아래처럼 만들었는데
// Score s1 = new Score();
// s1.init("giorno", 100, 90, 77);
// 여기에서 더 간결하게 Score s1 = new Score("giorno", 100, 90, 70);으로 쓰고싶어서
// 생성자 문법을 만들었다. this.compute()를 안에 집어넣기 위해서 만든게 아니다
// this.compute()는 init에 있었었다 어느 메서드에서도 호출 가능한것이지 생성자 문법에서만 가능한게 아니란말이다

package com.eomcs.oop.ex03;

public class Exam0420 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    void init(String name, int kor, int eng, int math) {
      System.out.println("Score(String,int,int,int) 호출!");
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.compute();
    }
    
    public void compute() {
      sum = kor + eng + math;
      average = sum / 3f;
    }
  }
  public static void main(String[] args) {
    Score s1 = new Score();
    Score s2 = new Score();
    s1.init("김", 100, 90, 77);
    s2.init("giorno", 100, 20, 50);
    System.out.printf("%s %d %d %d %d %.1f\n",
        s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.average);
  }
}
