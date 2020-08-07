package com.eomcs.oop.ex03;

public class Exam0940 {

  static class Monitor {

    int bright = 10;
    int contrast = 10;
    int widthRes = 480;
    int heightRes = 320;

    {
      System.out.println("인스턴스 초기화 블록 실행!");
      bright = 20;
      contrast = 20;
      widthRes = 800;
      heightRes = 600;
    }

    //호출될 생성자는 new 명령에서 지정한다
    // 예) new 클래스명(호출할 생성자의 전달할 파라미터 값)
    //=> 다음과 같이 파라미터의 값을 주지않으면 파라미터 값을 안 받는 생성자가 호출된다
    // 예) Monitor4()
    //=> new 명령을 실행하여 인스턴스를 생성할 때는 반드시 호출될 생성자를 지정해야 한다.
    // 예) new 클래스명();
    // => 다음과 같이 생성자를 지정하지 않으면 컴파일 오류가 발생한다
    // 예) new 클래스명;

    Monitor(){
      System.out.println("생성자 실행");
      this.bright = 50;
      this.contrast = 50;
      this.widthRes = 1920;
      this.heightRes = 1080;
      //인스턴스 초기화 블럭이 있는ㄷ 왜 생성자가 필요한가?
      // - 생성자는 외부에서 초기화시킬 값을 받을 수 있다
      // - 다만 현재의 생성자는 기본 생성자로서 외부로부터 값을 받지 않기 대문에
      // 초기화 블록이랑 다를 바가 없다
    }
    void display() {
      System.out.println("----------------------------");

    }
  }

  public static void main(String[] args) {
    Monitor m1 = new Monitor();
    m1.display();
    m1.bright = 40;
    m1.display();
  }
}
