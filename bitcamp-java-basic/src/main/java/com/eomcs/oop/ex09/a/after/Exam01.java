//Worker 구현체 사용
package com.eomcs.oop.ex09.a.after;

public class Exam01 {

  public static void main(String[] args) {

    Worker w1 = new BlueWorker();
    Worker w2 = new WhiteWorker();
    Worker w3 = new JubuWorker();

    w1.execute();
    w2.execute();
    w3.execute();

    Worker w;
    // Worker 객체를 저장하는 변수 w
    // Worker 객체를 가리키는 변수 w

  }
}
