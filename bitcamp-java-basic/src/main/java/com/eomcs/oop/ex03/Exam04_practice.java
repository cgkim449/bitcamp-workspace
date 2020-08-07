package com.eomcs.oop.ex03;

public class Exam04_practice {
  static class SmartPhone {
    
    int volume;
    int bright;
    int contrast;
    
    public SmartPhone() {
      System.out.println("SmartPhone() 생성자 호출됨!");
    }
    public SmartPhone(int a) {
      System.out.println("SmartPhone(int) 생성자 호출됨!");
    }
    
    public SmartPhone(String str, int a) {
      System.out.println("SmartPhone(String, int) 생성자 호출됨!");
    }
    public SmartPhone(int a, String str) {
      System.out.println("SmartPhone(int, String) 생성자 호출됨!");
    }
  }
  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone();
    SmartPhone obj2 = new SmartPhone(100);
    SmartPhone obj3 = new SmartPhone("!", 1);
    SmartPhone obj4 = new SmartPhone(1, "!");
  }
}