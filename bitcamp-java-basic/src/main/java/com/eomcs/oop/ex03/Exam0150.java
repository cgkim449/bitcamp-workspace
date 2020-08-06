package com.eomcs.oop.ex03;

public class Exam0150 {
  static class Car {
    // 스태틱 필드
    // - 모든 인스턴스가 공유하는 값(특히 상수값을 많이 이용한다)
    static int count;
    static final int SEDAN = 1;
    static final int TRUCK = 2;

    String model;
    String no;
    int cc;
    int type;
  }

  public static void main(String[] args) {
    Car c1 = new Car();
    Car c2 = new Car();

    c1.model = "티코";
    c1.type = Car.SEDAN;
    Car.count++;

    c2.model = "소나타";
    c2.type = Car.TRUCK;
    Car.count++;
    //자동차를 만들때마다 카운트를 증가시켜보자, 차의 개수를 세자

    System.out.printf("%s\n", c1.model);
    System.out.printf("%s\n", c2.model);
    System.out.println(Car.count);
  }
}
