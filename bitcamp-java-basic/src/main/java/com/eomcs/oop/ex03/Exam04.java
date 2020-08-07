// 생성자는 여러개 정의할 수 있다
// 즉 초기화를 여러방법으로 할 수 있다는 거다

// 생성자를 사용하는 이유 : 초기화, 간결성( this.compute(); )

package com.eomcs.oop.ex03;

public class Exam04 {
  
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float averages;
    
    Score() {
      //다른 생성자를 호출할 때는 this()를 사용한다
      // 단, 생성자의 첫문장으로 와야한다
      this("이름없음");
      System.out.println("Score()");
    }
    
    Score(String name) {
      
    }
    
    Score(String name, int kor, int eng, int math){
      System.out.println("Score(String,int,int,int) 호출!");
    }
  }
}
