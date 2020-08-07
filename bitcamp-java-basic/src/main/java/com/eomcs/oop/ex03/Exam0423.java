//# 생성자 this(); : 생성자안에서 다른 생성자를 호출, 반드시 첫 문장이어야한다
// - 일반 메서드에서 생성자를 임의로 호출할 수 없다
// - 레퍼런스로 생성자를 임의로 호출할 수 없다
//

package com.eomcs.oop.ex03;

public class Exam0423 {

  static class SmartPhone {

    int volume;
    int bright;
    int contrast;

    public SmartPhone() {
      //this(...) <== 생성자 안에서 다른 생성자를 호출하는 문법
      this(50, 50, 50);
      System.out.println("SmartPhone() 생성자 호출됨!");
      //this(50, 50, 50); // 다른생성자를 호출할 때는 반드시 첫 문장이어야 한다
    }

    public SmartPhone(int volume) {
      System.out.println("SmartPhone(int) 생성자 호출됨!");
      this.volume = volume;
      this.bright = 50;
      this.contrast = 50;
    }

    public SmartPhone(int volume, int bright) {
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
      // 일반 메서드에서 생성자를 임의로 호출할 수 없다!
      // this();
    }
  }

  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone();

    // obj1.Smartphone(); , 레퍼런스로 생성자를 임의로 호출할 수 없다, new 때
  }
}
