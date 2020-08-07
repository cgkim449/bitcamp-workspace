// # 생성자 호출 막기 = 인스턴스 생성을 막기
// - private 생성자: 같은 클래스! 내에서만 쓸 수 있다
// - 걍 생성자 : 같은 패키지에서만?
// - public 생성자 : 다른 패키지에서도?

package com.eomcs.oop.ex03;

class SmartPhone {

  int volume;
  int bright;
  int contrast;

  SmartPhone() { // 같은 블럭 내에서만 쓸 수 있다

  }

  private SmartPhone(int volume) {
    System.out.println("SmartPhone(int) 생성자 호출됨!");
    this.volume = volume;
    this.bright = 50;
    this.contrast = 50;
  }

  public SmartPhone(int volume, int bright) {
    this(10);
    System.out.println("SmartPhone(int, int) 생성자 호출됨!");
    this.volume = volume;
    this.bright = bright;
    this.contrast = 50;
  }

  public SmartPhone(int volume, int bright, int contrast) {
    System.out.println("SmartPhone(int, int, int) 생성자 호출됨!");
    this.volume = volume;
    this.bright = bright;
    this.contrast = contrast;
  }

  void m1() {
  }
}

public class Exam0424 { // public 클래스는 반드시 파일명과 일치해야한다


  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone(10, 10);
  }
}
