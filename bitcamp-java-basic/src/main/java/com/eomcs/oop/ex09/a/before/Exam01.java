package com.eomcs.oop.ex09.a.before;

public class Exam01 {

  public static void main(String[] args) {

    BlueWorker w1 = new BlueWorker();
    WhiteWorker w2 = new WhiteWorker();
    JubuWorker w3 = new JubuWorker();

    w1.doFight();
    w2.doZzingZzing();
    w3.doSsingSsing();

    // 결론!
    // => 유사한 일을 하는데 객체 사용법이 다르다면 쓰기가 매우 불편하다.
    //
    // 해결책!
    // => 유사한 일을 하는 객체에 대해 사용법을 통일하자.
    // 
    // 방법!
    // => 객체 사용 규칙을 정의한다.
    // => 그리고 클래스를 정의할 때 그 규칙에 따라 만든다.
    // => 그러면 규칙에 따라 만든 클래스를 사용할 때는
    //    일관된 방법으로 메서드를 호출할 수 있어 
    //    코딩하기가 훨씬 편해지고, 
    //    유지보수가 쉬워진다.
    //
    // 이렇게 객체의 사용 규칙(호출 규칙)을 정의하는 문법이 "인터페이스(interface)"이다.
    //
  }

}
